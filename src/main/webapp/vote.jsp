<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <title>Votação</title>
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
        %>
        <header id="menu">
        	<p id="user"><%=resUser%> - <%=resInscriptionNumber%> </p>
	        <a class="btn btn-light" href="home.jsp">Home</a>
	        <a class="btn btn-light" href="login.jsp">Sair</a>
       	</header>
       	<div class="welcome center-block">
            <h1>Votação</h1>
            <div>  
                <form id="formVote" action="informationCandidate" method="post">
                	<label>Digite o número do candidato escolhido:</label><br/>
                	<input type="text" name="numberCandidate" id="numberCandidate"/>
                    <input id="getInfoCandidate" class="btn btn-light" type="submit" value="Enviar" />
                </form>
				<p id="result"><%=res%></p>
            </div>
       	</div>
    </body>
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script>
		$(document).ready(function() {
			$("#getInfoCandidate").click(function() {
				$(':input','#formVote').val('');
			})
		}
	</script>
</html>