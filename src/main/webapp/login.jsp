<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <title>Conscious</title>
    </head>
    <body>
        <% 	String result = (String) request.getAttribute("result");
        	String res = "";
        	if (result != null) {
        		res = result;
        	};
        %>
        <div class="login container">
            <h1>Conscious</h1>
            <h3>Seu site de votação consciente!</h3>
             <div>
                <form id="form_id" action="auth" method="post" name="myform">
                    <label for="username">Nº do Tí­tulo:</label>
                    <br/>
                    <input type="text" name="inscriptionNumber" id="inscriptionNumber">
                    <br/>
                    <label for="password">Senha:</label><br/>
                    <input type="password" name="password" id="password"/>
                    <br/>
					<button type="submit" class="btn" value="Login" id="submit">Login</button>           	
                	<p id="result"><%=res%></p>
                </form>
            </div>
        </div>
        <!-- <script src="js/login.js"></script>  -->
 		<!-- <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script> -->
    </body>
</html>