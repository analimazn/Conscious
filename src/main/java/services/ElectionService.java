package services;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import utils.JPAUtil;
import services.*;
import model.*;
 
public class ElectionService {
    private static ElectionService instance;
	protected EntityManager entityManager;
    public static int candidateChosen = 0;
    
	public ElectionService() {
        entityManager = JPAUtil.getEntityManager();
    }
    
    public static ElectionService getInstance() {
        if (instance == null) {
            instance = new ElectionService();
        }
        return instance;
    }
    
    public List<Election> getListOfElection(){
    	entityManager.getTransaction().begin();
        List<Election> listElection = new ArrayList<Election>();
        try {
            String strQuery = "SELECT election FROM Election election";
            Query query = entityManager.createQuery(strQuery);
            listElection = (List<Election>) query.getResultList();
        } catch (NoResultException nre) {
        	System.out.println(nre);
        } finally {
            entityManager.getTransaction().commit();
        }
    	return listElection;
    }
    
    public void registerVoteToCandidate(){
        try {
           CandidateService candidateService = new CandidateService();
           Candidate candidate = candidateService.getCandidateId(ElectionService.candidateChosen);
           updateCandidateVoteIntoElection(candidate.getIdCandidate());
        } catch (NoResultException nre) {
        	System.out.println(nre);
        } 
    }
    
    public void updateCandidateVoteIntoElection(int candidateId){
    	try {    			    			
			Election candidateElection = entityManager.find(Election.class, candidateId);
			entityManager.getTransaction().begin();
			int computeVote = candidateElection.getQuantityVotes() + 1;
			candidateElection.setQuantityVotes(computeVote);
		} catch (Exception err) {
			System.out.println(err);
		} finally {
    		entityManager.getTransaction().commit();
		}
    }

}