<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <title>Informações do candidato</title>
    </head>
    <body>
     	<% 	
	     	String user = (String) request.getSession().getAttribute("user");
			String inscriptionNumber = (String) request.getSession().getAttribute("inscriptionNumber");
	 		String userType = (String) request.getSession().getAttribute("userType");
	 		String userEnabled = (String) request.getSession().getAttribute("userEnabled");	
	 		String result = (String) request.getAttribute("result");
	 		
	    	String res = "";
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
	
	    	if (result != null) {
	    		res = result;
	    	};
     
     		String nameCandidate = (String) request.getSession().getAttribute("nameCandidate");
     		String photoCandidate = (String) request.getSession().getAttribute("photoCandidate");
     		int numberCandidate = (int) request.getSession().getAttribute("numberCandidate");
     		String partyCandidate = (String) request.getSession().getAttribute("partyCandidate");
     		
        	String resNameCandidate = "";
        	String resPhotoCandidate = "";
        	int resNumberCandidate = 0;
        	String resPartyCandidate = "";
   
        	if (nameCandidate != null) {
        		resNameCandidate = nameCandidate.toUpperCase();
        		resPhotoCandidate = photoCandidate;
        		resNumberCandidate = numberCandidate;
        		resPartyCandidate = partyCandidate;
        	};
        %>
        <header id="menu">
        	<p id="user"><%=user%> - <%=inscriptionNumber%> </p>
	        <a class="btn btn-light" href="home.jsp">Home</a>
	        <a class="btn btn-light" href="login.jsp">Sair</a>
       	</header>
       	<div class="welcome center-block">
	       	<div class="container">
	            <h1>Informações do candidato: </h1>
	            <div id="infoCandidate" class="container-secondary">
		            <form id="formSendVote" action="computeVote" method="post">
		             	<h2 id="nameCandidate"><%=resNameCandidate %></h2>
		                <img id="photoCandidate" src=<%=resPhotoCandidate %>  height="150px" width="150px">
		                <h3 id="numberCandidate" name="numberCandidate"><%=resNumberCandidate %></h3>
		                <h3 id="partyCandidate"><%=resPartyCandidate %></h3>
						<a class="btn btn-outline-danger" href="vote.jsp">CANCELAR</a>
						<input class="btn btn-outline-success" type="submit" value="CONFIRMAR" />
		            </form>
	            </div>
	        </div>
       	</div>
    </body>
</html>