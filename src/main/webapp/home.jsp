<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <title>Home</title>
    </head>
    <body>
     	<% 	String user = (String) request.getSession().getAttribute("user");
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
        	<p id="inscriptionNumber"><%=resInscriptionNumber%></p>
        	<p id="userType"><%=resUserType%></p>
        	<p id="userEnabled"><%=resUserEnabled%></p>
        </header>
       	<div class="welcome center-block">
   			<h1>Olá <%=resUser%>! Você está no site de votação Conscious.</h1>
       	</div>
       	<% request.getSession().setAttribute("user", resUser);%>
        <% request.getSession().setAttribute("inscriptionNumber", resInscriptionNumber);%>
        <% request.getSession().setAttribute("userType", resUserType);%>
        <% request.getSession().setAttribute("userEnabled", resUserEnabled);%>
    </body>
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script>
		$(document).ready(function() {
			var userType = $('#userType').html();
			var userEnabled = $('#userEnabled').html();
			var userEnabledLength = userEnabled.length;

			if (userType == 'CHEFESECAO') {
				var button1 =  userEnabledLength == 1 ? "<button id='vote'><a href='vote.jsp'>Votar</a></button>" : "";
                var button2 = "<button id='validate'><a href='validate.jsp'>Validar usuário</a></button>";
                var button3 = "<button id='print'><a href='print.jsp'>Imprimir resultado</a></button>";
                var button4 = "<button id='out'><a href='login.jsp'>Sair</a></button>";            
				$("#menu").append(button1, button2, button3, button4); 
			} else if (userType == 'MESARIO') {
				var button1 =  userEnabledLength == 1 ? "<button id='vote'><a href='vote.jsp'>Votar</a></button>" : "";
                var button2 = "<button id='validate'><a href='validate.jsp'>Validar usuário</a></button>";
                var button3 = "<button id='out'><a href='login.jsp'>Sair</a></button>";            
				$("#menu").append(button1, button2, button3); 
			} else {
				var button1 =  userEnabledLength == 1 ? "<button id='vote'><a href='vote.jsp'>Votar</a></button>" : "";
                var button2 = "<button id='out'><a href='login.jsp'>Sair</a></button>";           
				$("#menu").append(button1, button2); 
			}
		})
	 </script>
</html>