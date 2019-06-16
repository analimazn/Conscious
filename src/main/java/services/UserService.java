package services;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import utils.JPAUtil;
import model.User;
 
public class UserService {
    private static UserService instance;
    protected EntityManager entityManager;
    public static User userLogged;
    
    public UserService() {
        entityManager = JPAUtil.getEntityManager();
    }
    
    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
    
    public User authenticateUser(String inscriptionNumber, String password) {
        User user = getUserByInscriptionNumber(inscriptionNumber);
		if(user != null && user.getInscriptionNumber().
      		equals(inscriptionNumber) && user.getPassword().equals(password)) {
          return user;
		}
        return null;
    }
 
    public User getUserByInscriptionNumber(String inscriptionNumber) {
    	entityManager.getTransaction().begin();
        User user = null;
    	try {
            String strQuery = "SELECT user FROM User user WHERE inscriptionNumber='"+inscriptionNumber+"'";
            Query query = entityManager.createQuery(strQuery);
        	user = (User) query.getSingleResult();
    	} catch (NoResultException nre){
        	System.out.println(nre);
        } finally {
        	entityManager.getTransaction().commit();
        }
    	return user;
    }
    
    public List<User> getListOfUsersToEnabled(){
    	entityManager.getTransaction().begin();
        List<User> listUsers = new ArrayList<User>();
        try {
            String strQuery = "SELECT user FROM User user WHERE enabled = 0";
            Query query = entityManager.createQuery(strQuery);
            listUsers = (List<User>) query.getResultList();
        } catch (NoResultException nre) {
        	System.out.println(nre);
        } finally {
            entityManager.getTransaction().commit();
        }
    	return listUsers;
    }
    
    public List<User> getListOfUsersEnabled(){
    	entityManager.getTransaction().begin();
        List<User> listUsers = new ArrayList<User>();
        try {
            String strQuery = "SELECT user FROM User user WHERE enabled = 1";
            Query query = entityManager.createQuery(strQuery);
            listUsers = (List<User>) query.getResultList();
        } catch (NoResultException nre) {
        	System.out.println(nre);
        } finally {
            entityManager.getTransaction().commit();
        }
    	return listUsers;
    }
    
    
    public boolean enableUser(int userId) {
    	boolean result = false;
    	try {    			    			
			User userToEnable = entityManager.find(User.class, userId);
			entityManager.getTransaction().begin();
			userToEnable.setEnabled(true);
		} catch (Exception err) {
			System.out.println(err);
		} finally {
    		entityManager.getTransaction().commit();
		}
    	return result;
    }
    
    public void registerVoteToUser(int userId) {
    	try {    			    			
			User userToEnable = entityManager.find(User.class, userId);
			entityManager.getTransaction().begin();
			userToEnable.setVoted(true);
		} catch (Exception err) {
			System.out.println(err);
		} finally {
    		entityManager.getTransaction().commit();
		}
    }
    
		//String strQuery = "UPDATE User SET enabled = 1 where inscriptionNumber='"+inscriptionNumber+"'";
		//Query query = entityManager.createQuery(strQuery);
		
		//int updateUser = query.executeUpdate();
		//System.out.println(updateUser);
		//String strQuery = "update User user set enabled = 1 where idUser='"+id+"'";
		//Query query = entityManager.createQuery(strQuery);

}