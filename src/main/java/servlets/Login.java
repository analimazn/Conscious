package servlets;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.JPAUtil;

@WebServlet("")
public class Login extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
    	
        ServletContext sc = req.getServletContext();
        JPAUtil.shutdown();
        try {
        	sc.getRequestDispatcher("/login.jsp").forward(req, resp);            
        } catch (Exception e) {}
    }
}