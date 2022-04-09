package bg.tuvarna.sit.real_estate_proj.data.repositories;

import bg.tuvarna.sit.real_estate_proj.data.access.Connection;
import org.apache.log4j.Logger;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserRepository implements DAORepository{
    private static final Logger log= Logger.getLogger(UserRepository.class);

    public static UserRepository getInstance(){
        return UserRepository.TicketsRepositoryHolder.INSTANCE;
    }

    private static class TicketsRepositoryHolder {

        public static UserRepository INSTANCE=new UserRepository();
    }

    @Override
    public void save(User obj){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("User saved successfully!");
        }
        catch(Exception ex){
            log.error(("User save error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(User obj){
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.update(obj);
            log.info("User updated successfully");
        }
        catch(Exception ex){
            log.error(("User update error" + ex.getMessage()));
        }
        finally{
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(User obj){
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.delete(obj);
            log.info("User deleted successfully");
        }
        catch (Exception ex){
            log.error(("User delete error " + ex.getMessage()));
        }
        finally{
            transaction.commit();
            session.close();
        }
    }

    @Override
    public User getById(int id){
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        User retUser;

        try{
            String jql = "SELECT u FROM User u WHERE idUser = :id";
            Query query=session.createQuery(jql, User.class);
            query.setParameter("id", id);
            retUser=(User) query.getSingleResult();
            log.info("Get user by id");
        }
        catch (Exception ex){
            retUser=null;
            log.error(("Get user error: "+ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

}
