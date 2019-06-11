package services;
 
import java.util.ArrayList;
import java.util.List;
import model.User;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
 
public class UserService {
 
    public boolean authenticateUser(String inscriptionNumber, String password) {
        User user = getUserByInscriptionNumber(inscriptionNumber);         
        
        if(user!=null && user.getInscriptionNumber().equals(inscriptionNumber) && user.getPassword().equals(password)) {
            return true;
        }else{
            return false;
        }
    }
 
    public User getUserByInscriptionNumber(String inscriptionNumber) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        User user = null;
        
        try {
            tx = session.getTransaction();
            tx.begin();
            
            Query<User> query = session.createQuery("from User where inscriptionNumber='"+inscriptionNumber+"'");
            user = query.uniqueResult();
            tx.commit();
            
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }
     
    public List<User> getListOfUsers(){
        List<User> list = new ArrayList<User>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;       
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from User").list();                       
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}