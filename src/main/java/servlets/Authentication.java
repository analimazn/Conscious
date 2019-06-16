package servlets;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.UserService;
import model.User;

@WebServlet("/authentication")
public class Authentication extends HttpServlet {   
	private static final long serialVersionUID = 1L;

	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8"); 
	        
            String inscriptionNumber = req.getParameter("inscriptionNumber");
	        String password = req.getParameter("password");
	        String resUserEnabled = " ";
	        	        
	        ServletContext sc = req.getServletContext();
	        
	        if (inscriptionNumber.isEmpty() || password.isEmpty()) {
	        	req.setAttribute("result", "Por favor, entre com valores válidos");
	        	sc.getRequestDispatcher("/login.jsp").forward(req, resp);
	        } else {
		        UserService userService = new UserService();
		        User user = userService.authenticateUser(inscriptionNumber, password);
		        if (user != null) {
		        	if (user.isEnabled() == false) {
		        		resUserEnabled = "Você ainda não está habilitado para votar.";
		        	} else if (user.isEnabled() == true && user.isVoted() == true) {
		        		resUserEnabled = "Seu voto já foi computado.";
		        	}
		        	UserService.userLogged = user;
		        	
		        	req.getSession().setAttribute("user", user.getUserName());
		        	req.getSession().setAttribute("inscriptionNumber", user.getInscriptionNumber());
		        	req.getSession().setAttribute("userType", user.getUserType());
		        	req.getSession().setAttribute("userEnabled", resUserEnabled);
		    		sc.getRequestDispatcher("/home.jsp").forward(req, resp);

		        } else {
		        	req.setAttribute("result", "Usuário ou senha incorretos");
		        	sc.getRequestDispatcher("/login.jsp").forward(req, resp);
		        }
	        }
        } catch(Exception e) {
         	System.out.println(e);
        }
    }
}