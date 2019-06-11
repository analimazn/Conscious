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
	        <button><a href="home.jsp">Home</a></button>
	        <button><a href="login.jsp">Sair</a></button>
       	</header>
       	<div class="welcome center-block">
	       	<div class="container">
	            <h1>Votação</h1>
	            <div>
	                <label>Digite o número do candidato escolhido:</label><br/>
	                <form action="" method="post">
	                    <input type="text" name="number" id="number"/>
	                    <button type="submit" name="submit" value="Send">Enviar</button>
	                </form>
	            </div>  
	            <div class="container-secondary">
	                <img src="img/businessman.png">
	                <h3>777</h3>
	                <h3>CHMOD</h3>
	                <button type="" name="return" id="return">RETORNAR</button>
	                <button type="" name="confirm" id="confirm">CONFIRMAR</button>
	            </div>
	        </div>
       	</div>
    </body>

    <!--<script type="text/javascript" src="js/jquery-3.4.0.slim.min.js"></script>
    <script type="text/javascript" src="js/popper.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/script.js"></script>-->
</html>