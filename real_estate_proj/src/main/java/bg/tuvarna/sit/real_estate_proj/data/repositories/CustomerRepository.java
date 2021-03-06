package bg.tuvarna.sit.real_estate_proj.data.repositories;

import bg.tuvarna.sit.real_estate_proj.data.access.Connection;
import bg.tuvarna.sit.real_estate_proj.data.entities.Customer;
import org.apache.log4j.Logger;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CustomerRepository implements DAORepository<Customer>{

    private static final Logger log= Logger.getLogger(CustomerRepository.class);

    public static CustomerRepository getInstance(){
        return CustomerRepository.CustomerRepositoryHolder.INSTANCE;
    }

    private static class CustomerRepositoryHolder {

        public static CustomerRepository INSTANCE=new CustomerRepository();
    }

    @Override
    public void save(Customer obj){
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.save(obj);
            log.info("Customer saved successfully");
        }
        catch (Exception ex){
            log.error(("Customer save error: " + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(Customer obj){
        Session session= Connection.openSession();
        Transaction transaction= session.beginTransaction();
        try{
            session.update(obj);
            log.info("Customer updated successfully");
        }
        catch (Exception ex){
            log.error(("Customer update error: " + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(Customer obj){
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Customer deleted successfully");
        }
        catch (Exception ex){
            log.error(("Customer delete error: " + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public Customer getById(int id){
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();

        Customer retCustomer;

        try{
            String jql= "SELECT u FROM Customer u WHERE idCustomer=:id";
            Query query=session.createQuery(jql, Customer.class);
            query.setParameter("id", id);
            retCustomer=(Customer) query.getSingleResult();
            log.info("Get customer by id");
        }
        catch (Exception ex){
            retCustomer=null;
            log.error(("Get customer error: "+ ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
        return retCustomer;
    }

    @Override
    public List<Customer> getAll(){
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Customer> customers=new LinkedList<>();

        try{
            String jql="SELECT c FROM Customer c";
            customers.addAll((session.createQuery(jql,Customer.class).getResultList()));
            log.info("Get all customers");
        }
        catch (Exception ex){
            log.error("Get Customer error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return customers;
    }

}
