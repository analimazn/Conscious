<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <title>Habilitados com Sucesso</title>
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
   			<h1>Seu voto foi computado com sucesso!</h1>
       	</div>
    </body>
</html>