package servlets;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.UserService;
import model.User;

@WebServlet("/validate")
public class Validate extends HttpServlet {   
	private static final long serialVersionUID = 1L;
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
        try {
            resp.setCharacterEncoding("UTF-8");
            String usersToEnableList[] = req.getParameterValues("user");
            UserService userService = new UserService();
            ServletContext sc = req.getServletContext();
           
            for (String userInscriptionNumber: usersToEnableList) {
        	   String inscriptionNumber = userInscriptionNumber.replace("/", "");
        	   User user = userService.getUserByInscriptionNumber(inscriptionNumber);
        	   userService.enableUser(user.getIdUser());
        	   sc.getRequestDispatcher("/validateSuccess.jsp").forward(req, resp);
           }
        } catch(Exception e) {
         	System.out.println(e);
        }
    }
}