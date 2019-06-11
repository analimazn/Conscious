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
        	<p id="user"><%=resUser%></p>
	       	<p id="inscriptionNumber"><%=resInscriptionNumber%></p>
	       	<p id="userType"><%=resUserType%></p>
	       	<p id="userEnabled"><%=resUserEnabled%></p>
	        <button><a href="home.jsp">Home</a></button>
	        <button><a href="login.jsp">Sair</a></button>
       	</header>
       	<div class="welcome center-block">
       	   	<div class="container">          
            	<h1>Impressão do resultado</h1>
	            <table class="container-secondary">
	                <tr>
	                    <th>Candidato</th>
	                    <th>Qtd de Votos</th>
	                </tr>
	                <tr>
	                    <td>Candidato 1</td>
	                    <td>30</td>
	                </tr>
	                <tr>
	                    <td>Candidato 2</td>
	                    <td>60</td>
	                </tr>
	                <tr>
	                    <td>Candidato 3</td>
	                    <td>40</td>
	                </tr>
	                <tr>
	                    <td>TOTAL</td>
	                    <td>130</td>
	                </tr>
	            </table>
	        </div>
       	</div>
    </body>

    <!--<script type="text/javascript" src="js/jquery-3.4.0.slim.min.js"></script>
    <script type="text/javascript" src="js/popper.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/script.js"></script>-->
</html>