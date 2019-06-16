package services;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import utils.JPAUtil;
import model.Candidate;
 
public class CandidateService {
    private static CandidateService instance;
    protected EntityManager entityManager;
    
    public CandidateService() {
        entityManager = JPAUtil.getEntityManager();
    }
    
    public static CandidateService getInstance() {
        if (instance == null) {
            instance = new CandidateService();
        }
        return instance;
    }
 
    public Candidate getCandidateByNumber(String candidateNumber) {
    	entityManager.getTransaction().begin();
    	Candidate candidate = null;
    	try {
            String strQuery = "SELECT candidate FROM Candidate candidate WHERE candidateNumber='"+candidateNumber+"'";
            Query query = entityManager.createQuery(strQuery);
            candidate = (Candidate) query.getSingleResult();
    	} catch (NoResultException nre){
        	System.out.println(nre);
        } finally {
        	entityManager.getTransaction().commit();
        }
    	return candidate;
    }
    
    public Candidate getCandidateId(int candidateNumber) {
    	entityManager.getTransaction().begin();
    	Candidate candidate = null;
    	try {
            String strQuery = "SELECT candidate FROM Candidate candidate WHERE candidateNumber='"+candidateNumber+"'";
            Query query = entityManager.createQuery(strQuery);
            candidate = (Candidate) query.getSingleResult();
    	} catch (NoResultException nre){
        	System.out.println(nre);
        } finally {
        	entityManager.getTransaction().commit();
        }
    	return candidate;
    }
}