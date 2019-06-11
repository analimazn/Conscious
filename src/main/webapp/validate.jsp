<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
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
        	<p id="user"><%=resUser%></p>
	       	<p id="inscriptionNumber"><%=resInscriptionNumber%></p>
	       	<p id="userType"><%=resUserType%></p>
	       	<p id="userEnabled"><%=resUserEnabled%></p>
	        <button><a href="home.jsp">Home</a></button>
	        <button><a href="login.jsp">Sair</a></button>
       	</header>
       	<div class="welcome center-block">
	       	<div class="container">
	            <h1>Habilitação de eleitores</h1>
	            <br/>
	            <h3>Por favor, selecione os usuários abaixo para habilitar:</h3>
	            <div class="container-secondary">
	                <form action="enableUser" method="post">
	                    <label for="user">User1</label>
	                    <input type="checkbox" name="user" value="user"/>
	                    <br/>
	                    <label for="user">User2</label>
	                    <input type="checkbox" name="user" value="user"/>
	                </form>
	            </div>
	            <button type="submit" name="submit" value="Send">Enviar</button>
	        </div>
       	</div>
    </body>

    <!--<script type="text/javascript" src="js/jquery-3.4.0.slim.min.js"></script>
    <script type="text/javascript" src="js/popper.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/script.js"></script>-->
</html>