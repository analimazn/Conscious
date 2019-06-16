<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="services.UserService"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <title>Validação</title>
    </head>
    <body>
     	<% 	
 			String user = (String) request.getSession().getAttribute("user");
			String inscriptionNumber = (String) request.getSession().getAttribute("inscriptionNumber");
     		String userType = (String) request.getSession().getAttribute("userType");
     		String userEnabled = (String) request.getSession().getAttribute("userEnabled");
        	
     		String resUser = "";
        	String resInscriptionNumber = "";
        	String resUserType = "";
        	String resUserEnabled = "";	
        	
        	if (user != null) {
        		resUser = user.toUpperCase();
        		resInscriptionNumber = inscriptionNumber;
        		resUserType = userType;
        		resUserEnabled = userEnabled;
        	};
        %>
        <header id="menu">
        	<p id="user"><%=resUser%> - <%=resInscriptionNumber%> </p>
	       	<p id="userEnabled"><%=resUserEnabled%></p>
	        <a class="btn btn-light" href="home.jsp">Home</a>
	        <a class="btn btn-light" href="login.jsp">Sair</a>
       	</header>
     	<div class="welcome center-block">
            <h1>Habilitação de eleitores</h1>
            <br/>
            <h3>Por favor, selecione os usuários abaixo para habilitar:</h3>          
        </div>
        <div class="container-table center-block">
			<form action="validate" method="post"> 
		       	<table class="table table-hover">
		           <thead class="thead-dark">
		               <tr>
		                   <th>Nome</th>
		                   <th>Nº do Título</th>
		                   <th>Data de Nascimento</th>
		                   <th>Selecionar</th>               
		               </tr>
		           	</thead>
		           	<tbody>
		               <%
		                   UserService userService = new UserService();
		                   List<User> list = userService.getListOfUsersToEnabled();
		                   for (User userItem : list) {
		                  	 String date = userItem.getBornDate().toGMTString().substring(0, 11);
		                  	 String dateWithoutTime = date.substring(0, 11);
		               %>
		                <tr>
		                    <td><%=userItem.getUserName() %></td>
		                    <td><%=userItem.getInscriptionNumber() %></td>
		                    <td><%= date %></td>
		                    <td><input type="checkbox" name="user" value=<%=userItem.getInscriptionNumber() %>/></td>
		                </tr>
		               <%}%>
		           <tbody>
				</table>
				<input class="btn btn-info" type="submit" value="Habilitar Selecionados" />
			</form>
		</div>
    </body>
</html>