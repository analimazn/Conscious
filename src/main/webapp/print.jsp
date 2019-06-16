<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="services.ElectionService"%>
<%@page import="model.Election"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <title>Impressão</title>
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
           	<h1>Impressão do resultado</h1>
           	<br/>
            <h3>Confira abaixo o resultado da eleição:</h3>          
        </div>
		<div class="container-table center-block">
	       	<table class="table table-hover">
	           <thead class="thead-dark">
	               <tr>
	                   <th>Partido</th>
	                   <th>Candidato</th>
	                   <th>Qtd. de votos</th>
	               </tr>
	           	</thead>
	           	<tbody>
	               <%
	                   ElectionService electionService = new ElectionService();
	                   List<Election> list = electionService.getListOfElection();
	                   int totalVotes = 0;
	                   for (Election electionItem : list) {
	                  	 String party = electionItem.getIdParty().getPartyName();
	                  	 String candidate = electionItem.getIdCandidate().getCandidateName();
	                  	 int qtdVotes = electionItem.getQuantityVotes();
	                  	 totalVotes += qtdVotes;
	               %>
	                <tr>
	                   	<td><%=party %></td>
	                    <td><%=candidate %></td>
	                    <td><%=qtdVotes %></td>
	                </tr>
	               	<%}%>
	                <tr>
					 	<th>Total de votos</th>
					 	<td></td>
					 	<td><%=totalVotes %></td>
					</tr>
	           	<tbody>				
			</table>
		</div>
    </body>
</html>