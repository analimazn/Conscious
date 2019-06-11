package utils;

import model.*;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
 
    private static final SessionFactory sessionFactory;
 
    static {
        try {
           Configuration configuration = new Configuration();
           Properties settings = new Properties();
           settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
           settings.put(Environment.URL, "jdbc:mysql://localhost:3306/conscious?serverTimezone=UTC");
           settings.put(Environment.USER, "root");
           settings.put(Environment.PASS, "root");
           settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
           settings.put(Environment.SHOW_SQL, "false");
           settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
           configuration.setProperties(settings);
           configuration.addAnnotatedClass(User.class);
           configuration.addAnnotatedClass(Candidate.class);
           configuration.addAnnotatedClass(County.class);
           configuration.addAnnotatedClass(DistrictFederal.class);
           configuration.addAnnotatedClass(Election.class);
           configuration.addAnnotatedClass(ElectoralSection.class);
           configuration.addAnnotatedClass(Party.class);
           ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                   .applySettings(configuration.getProperties()).build();
           sessionFactory = configuration.buildSessionFactory(serviceRegistry);        
    } catch (Throwable ex) {
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
       }
   }
 
    public static Session openSession() {
        return sessionFactory.openSession();
    }
}