package bg.tuvarna.sit.real_estate_proj.data.access;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {
    private static final Logger log=Logger.getLogger(Connection.class);
    public static SessionFactory sessionFactory;
    static{
        try{
            sessionFactory=new Configuration().configure().buildSessionFactory();
        }
        catch(Throwable ex){
            log.error("Initial SessionFactory created failed "+ex);
        }
    }
    public static Session openSession(){
        return sessionFactory.openSession();
    }
    public static void openSessionClose(){
        sessionFactory.close();
    }

}
