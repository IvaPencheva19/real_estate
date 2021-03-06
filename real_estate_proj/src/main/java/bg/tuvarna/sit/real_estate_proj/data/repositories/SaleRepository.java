package bg.tuvarna.sit.real_estate_proj.data.repositories;

import bg.tuvarna.sit.real_estate_proj.data.access.Connection;
import bg.tuvarna.sit.real_estate_proj.data.entities.Broker;
import bg.tuvarna.sit.real_estate_proj.data.entities.EstateCurrency;
import bg.tuvarna.sit.real_estate_proj.data.entities.RealEstate;
import bg.tuvarna.sit.real_estate_proj.data.entities.Sale;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.LinkedList;
import java.util.List;

public class SaleRepository implements DAORepository<Sale>{
    private static final Logger log= Logger.getLogger(SaleRepository.class);

    public static SaleRepository getInstance(){
        return SaleRepository.SaleRepositoryHolder.INSTANCE;
    }

    private static class SaleRepositoryHolder {

        public static SaleRepository INSTANCE=new SaleRepository();
    }

    @Override
    public void save(Sale obj){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("Sale saved successfully!");
        }
        catch(Exception ex){
            log.error(("Sale save error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(Sale obj){
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.update(obj);
            log.info("Sale updated successfully");
        }
        catch(Exception ex){
            log.error(("Sale update error" + ex.getMessage()));
        }
        finally{
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(Sale obj){
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Sale deleted successfully");
        }
        catch (Exception ex){
            log.error(("Sale delete error " + ex.getMessage()));
        }
        finally{
            transaction.commit();
            session.close();
        }
    }

    @Override
    public Sale getById(int id){
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        Sale retSale;

        try{
            String jql = "SELECT u FROM Sale u WHERE idSale = :id";
            Query query=session.createQuery(jql, Sale.class);
            query.setParameter("id", id);
            retSale=(Sale) query.getSingleResult();
            log.info("Get sale by id");
        }
        catch (Exception ex){
            retSale=null;
            log.error(("Get Sale error: "+ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
        return retSale;
    }

    public List<Sale> getAll(){
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Sale> sales=new LinkedList<>();

        try{
            String jql="SELECT s FROM Sale s";
            sales.addAll((session.createQuery(jql,Sale.class).getResultList()));
            log.info("Get all sales");
        }
        catch (Exception ex){
            log.error("Get Sale error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return sales;
    }

    public List<Sale> getSalesByBroker(Broker name) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Sale> sales=new LinkedList<>();

        try {
            String jql = "SELECT u FROM Sale u WHERE broker = :name";
            sales.addAll((session.createQuery(jql,Sale.class).setParameter("name", name).getResultList()));
            log.info("Get sales by brokers");
        }
        catch (Exception ex){
            log.error("Get sale error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return sales;
    }
}
