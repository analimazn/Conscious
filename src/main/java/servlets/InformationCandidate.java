package servlets;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.*;
import model.Candidate;

@WebServlet("/informationCandidate")
public class InformationCandidate extends HttpServlet {   
	private static final long serialVersionUID = 1L;

	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8"); 
	        
            String numberCandidate = req.getParameter("numberCandidate");	        
            String result = " ";
            
	        ServletContext sc = req.getServletContext();
	        
	        if (numberCandidate.isEmpty()) {
	        	req.setAttribute("result", "Por favor, entre com valores válidos");
	        	sc.getRequestDispatcher("/vote.jsp").forward(req, resp);
	        } else {
		        CandidateService candidateService = new CandidateService();
		        Candidate candidate = candidateService.getCandidateByNumber(numberCandidate);
		        ElectionService electionService = new ElectionService();
		        
		        if (candidate != null) {
		        	ElectionService.candidateChosen = candidate.getCandidateNumber();
		        	System.out.println(ElectionService.candidateChosen);
		        	
		        	req.getSession().setAttribute("nameCandidate", candidate.getCandidateName());
		        	req.getSession().setAttribute("numberCandidate", candidate.getCandidateNumber());
		        	req.getSession().setAttribute("partyCandidate", candidate.getIdPartyNumber().getPartyName());
		        	req.getSession().setAttribute("photoCandidate", candidate.getCandidateUrlPhoto() );
		    		sc.getRequestDispatcher("/informationsCandidate.jsp").forward(req, resp);
		        } else {
		        	req.setAttribute("result", "Candidato não encontrado.");
		        	sc.getRequestDispatcher("/vote.jsp").forward(req, resp);
		        }
	        }
        } catch(Exception e) {
         	System.out.println(e);
        }
    }
}