<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
                <form action="authentication" method="post">
                    <label for="username">Nº do Tí­tulo:</label>
                    <br/>
                    <input type="text" name="inscriptionNumber" id="inscriptionNumber">
                    <br/>
                    <label for="password">Senha:</label><br/>
                    <input type="password" name="password" id="password"/>
                    <br/>
                    <button type="submit" class="btn btn-light" value="Entrar">Login</button>           	
                	<p id="result"><%=res%></p>
                </form>
            </div>
        </div>
    </body>
</html>