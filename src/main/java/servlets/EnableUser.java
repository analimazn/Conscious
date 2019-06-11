/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import services.UserService;

@WebServlet("/enableUser")
public class EnableUser extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
    	String userLogged = (String) req.getSession().getAttribute("user");	
        ServletContext sc = req.getServletContext();
        
        /*try {
        	sc.getRequestDispatcher("/login.jsp").forward(req, resp);            
        } catch (Exception e) {}*/
    }
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8"); 
	        System.out.println("Helloo");
            String inscriptionNumber = req.getParameter("inscriptionNumber");
	        String password = req.getParameter("password");
	        String resUserEnabled = " ";
	        
	        UserService userService = new UserService();
	        boolean result = userService.authenticateUser(inscriptionNumber, password);
	        User user = userService.getUserByInscriptionNumber(inscriptionNumber);
	        
	        ServletContext sc = req.getServletContext();
	        
	        if (inscriptionNumber.isEmpty() || password.isEmpty()) {
	        	req.setAttribute("result", "Por favor, entre com valores válidos");
	        	sc.getRequestDispatcher("/login.jsp").forward(req, resp);
	        } else if (result == true) {
	        	
	        	if (user.isEnabled() == false) {
	        		resUserEnabled = "Você ainda não está habilitado para votar.";
	        	}
	        		        	
	        	req.getSession().setAttribute("user", user.getUserName());
	        	req.getSession().setAttribute("inscriptionNumber", user.getInscriptionNumber());
	        	req.getSession().setAttribute("userType", user.getUserType());
	        	req.getSession().setAttribute("userEnabled", resUserEnabled);
	    		sc.getRequestDispatcher("/home.jsp").forward(req, resp);
	    		
	        } else {
	        	req.setAttribute("result", "Usuário ou senha incorretos");
	            sc.getRequestDispatcher("/login.jsp").forward(req, resp);
	        }

        } catch(Exception e) {
         	System.out.println(e);
        }
    }
}