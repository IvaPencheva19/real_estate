package bg.tuvarna.sit.real_estate_proj.data.repositories;

import bg.tuvarna.sit.real_estate_proj.data.access.Connection;
import bg.tuvarna.sit.real_estate_proj.data.entities.RealEstate;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class RealEstateRepository implements DAORepository<RealEstate>{

    private static final Logger log= Logger.getLogger(RealEstateRepository.class);

    public static RealEstateRepository getInstance(){
        return RealEstateRepository.RealEstateRepositoryHolder.INSTANCE;
    }

    private static class RealEstateRepositoryHolder {

        public static RealEstateRepository INSTANCE=new RealEstateRepository();
    }

    @Override
    public void save(RealEstate obj){
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.save(obj);
            log.info("Real estate saved successfully");
        }
        catch (Exception ex){
            log.error(("Real estate save error: " + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(RealEstate obj){
        Session session= Connection.openSession();
        Transaction transaction= session.beginTransaction();
        try{
            session.update(obj);
            log.info("Real estate updated successfully");
        }
        catch (Exception ex){
            log.error(("Real estate update error: " + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(RealEstate obj){
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Real estate deleted successfully");
        }
        catch (Exception ex){
            log.error(("Real estate delete error: " + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public RealEstate getById(int id){
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();

        RealEstate retRealEstate;

        try{
            String jql= "SELECT u FROM RealEstate u WHERE idEstate=:id";
            Query query=session.createQuery(jql, RealEstate.class);
            query.setParameter("id", id);
            retRealEstate=(RealEstate) query.getSingleResult();
            log.info("Get real estate by id");
        }
        catch (Exception ex){
            retRealEstate=null;
            log.error(("Get real estate error: "+ ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
        return retRealEstate;
    }
}
