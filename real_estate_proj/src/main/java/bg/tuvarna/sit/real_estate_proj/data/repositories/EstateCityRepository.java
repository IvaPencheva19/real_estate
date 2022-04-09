package bg.tuvarna.sit.real_estate_proj.data.repositories;

import bg.tuvarna.sit.real_estate_proj.data.access.Connection;
import bg.tuvarna.sit.real_estate_proj.data.entities.EstateCity;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EstateCityRepository implements DAORepository<EstateCity> {
    private static final Logger log= Logger.getLogger(EstateCityRepository.class);

    public static EstateCityRepository getInstance(){
        return EstateCityRepository.EstateCityRepositoryHolder.INSTANCE;
    }

    private static class EstateCityRepositoryHolder {

        public static EstateCityRepository INSTANCE=new EstateCityRepository();
    }

    @Override
    public void save(EstateCity obj){
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.save(obj);
            log.info("Estate city saved successfully");
        }
        catch (Exception ex){
            log.error(("Estate city save error: " + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(EstateCity obj){
        Session session= Connection.openSession();
        Transaction transaction= session.beginTransaction();
        try{
            session.update(obj);
            log.info("Estate city updated successfully");
        }
        catch (Exception ex){
            log.error(("Estate city update error: " + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(EstateCity obj){
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Estate city deleted successfully");
        }
        catch (Exception ex){
            log.error(("Estate city delete error: " + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public EstateCity getById(int id){
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();

        EstateCity retEstateCity;

        try{
            String jql= "SELECT u FROM EstateCity u WHERE idCity=:id";
            Query query=session.createQuery(jql, EstateCity.class);
            query.setParameter("id", id);
            retEstateCity=(EstateCity) query.getSingleResult();
            log.info("Get estate city by id");
        }
        catch (Exception ex){
            retEstateCity=null;
            log.error(("Get estate city error: "+ ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
        return retEstateCity;
    }
}
