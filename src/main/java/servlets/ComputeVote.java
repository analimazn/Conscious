package servlets;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.*;
import model.*;

@WebServlet("/computeVote")
public class ComputeVote extends HttpServlet {   
	private static final long serialVersionUID = 1L;

	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8"); 
	        
            System.out.println(ElectionService.candidateChosen);
            System.out.println(UserService.userLogged.getUserName());
	        ServletContext sc = req.getServletContext();
	        
	        UserService userService = new UserService();
	        ElectionService electionService = new ElectionService();
	        
	        if (UserService.userLogged.isVoted() == true) {
	    		sc.getRequestDispatcher("/voteFail.jsp").forward(req, resp);
	        } else {
	        	userService.registerVoteToUser(UserService.userLogged.getIdUser());
	        	electionService.registerVoteToCandidate();
	        	sc.getRequestDispatcher("/voteSuccess.jsp").forward(req, resp);
	        }
        } catch(Exception e) {
         	System.out.println(e);
        }
    }
}