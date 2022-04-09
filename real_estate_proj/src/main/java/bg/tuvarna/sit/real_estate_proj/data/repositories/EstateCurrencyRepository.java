package bg.tuvarna.sit.real_estate_proj.data.repositories;

import bg.tuvarna.sit.real_estate_proj.data.access.Connection;
import bg.tuvarna.sit.real_estate_proj.data.entities.EstateCurrency;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EstateCurrencyRepository implements DAORepository<EstateCurrency>{
    private static final Logger log= Logger.getLogger(EstateCurrencyRepository.class);

    public static EstateCurrencyRepository getInstance(){
        return EstateCurrencyRepository.EstateCurrencyRepositoryHolder.INSTANCE;
    }

    private static class EstateCurrencyRepositoryHolder {

        public static EstateCurrencyRepository INSTANCE=new EstateCurrencyRepository();
    }

    @Override
    public void save(EstateCurrency obj){
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.save(obj);
            log.info("Estate currency saved successfully");
        }
        catch (Exception ex){
            log.error(("Estate currency save error: " + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(EstateCurrency obj){
        Session session= Connection.openSession();
        Transaction transaction= session.beginTransaction();
        try{
            session.update(obj);
            log.info("Estate currency updated successfully");
        }
        catch (Exception ex){
            log.error(("Estate currency update error: " + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(EstateCurrency obj){
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Estate currency deleted successfully");
        }
        catch (Exception ex){
            log.error(("Estate currency delete error: " + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public EstateCurrency getById(int id){
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();

        EstateCurrency retEstateCurrency;

        try{
            String jql= "SELECT u FROM EstateCurrency u WHERE idCurrency=:id";
            Query query=session.createQuery(jql, EstateCurrency.class);
            query.setParameter("id", id);
            retEstateCurrency=(EstateCurrency) query.getSingleResult();
            log.info("Get estate currency by id");
        }
        catch (Exception ex){
            retEstateCurrency=null;
            log.error(("Get estate currency error: "+ ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
        return retEstateCurrency;
    }
}
