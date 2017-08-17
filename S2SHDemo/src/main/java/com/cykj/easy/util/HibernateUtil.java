package com.cykj.easy.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateUtil {
	/** ThreadLocal Session Map */  
    public static final ThreadLocal<Session> SESSIONMAP = new ThreadLocal<Session>();  
    private static final SessionFactory sessionFactory;  
    private static Logger LOGGER = LogManager.getLogger(HibernateUtil.class.getName());
  
    static {  
        try {  
            LOGGER.debug("HibernateUti.static - loading cofig");  
            ApplicationContext ac = new ClassPathXmlApplicationContext(
    				"/applicationContext.xml");
            sessionFactory =(SessionFactory) ac.getBean("sessionFactory");  
            LOGGER.debug("HibernateUtil.static - end");  
        } catch (Throwable ex) {  
            ex.printStackTrace();  
            LOGGER.error("HibernateUti error : ExceptionInInitializerError");  
            throw new ExceptionInInitializerError(ex);  
        }  
    }  
      
    private HibernateUtil() {  
          
    }  
  
    public static Session getSession() throws HibernateException {  
        Session session = SESSIONMAP.get();  
          
        if(session == null) {  
            session = sessionFactory.openSession();  
            SESSIONMAP.set(session);  
        }  
          
        return session;  
    }  
      
    public static void closeSession() throws HibernateException {  
        Session session = SESSIONMAP.get();  
        SESSIONMAP.set(null);  
          
        if(session != null) {  
            session.close();  
        }  
    }  
}
