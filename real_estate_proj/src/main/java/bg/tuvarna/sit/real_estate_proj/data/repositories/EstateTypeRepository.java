package bg.tuvarna.sit.real_estate_proj.data.repositories;

import bg.tuvarna.sit.real_estate_proj.data.access.Connection;
import bg.tuvarna.sit.real_estate_proj.data.entities.EstateCurrency;
import bg.tuvarna.sit.real_estate_proj.data.entities.EstateType;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.LinkedList;
import java.util.List;

public class EstateTypeRepository implements DAORepository<EstateType>{

    private static final Logger log= Logger.getLogger(EstateTypeRepository.class);

    public static EstateTypeRepository getInstance(){
        return EstateTypeRepository.EstateTypeRepositoryHolder.INSTANCE;
    }

    private static class EstateTypeRepositoryHolder {

        public static EstateTypeRepository INSTANCE=new EstateTypeRepository();
    }

    @Override
    public void save(EstateType obj){
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.save(obj);
            log.info("Estate type saved successfully");
        }
        catch (Exception ex){
            log.error(("Estate type save error: " + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(EstateType obj){
        Session session= Connection.openSession();
        Transaction transaction= session.beginTransaction();
        try{
            session.update(obj);
            log.info("Estate type updated successfully");
        }
        catch (Exception ex){
            log.error(("Estate type update error: " + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(EstateType obj){
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Estate type deleted successfully");
        }
        catch (Exception ex){
            log.error(("Estate type delete error: " + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public EstateType getById(int id){
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();

        EstateType retEstateType;

        try{
            String jql= "SELECT u FROM EstateType u WHERE idType=:id";
            Query query=session.createQuery(jql, EstateType.class);
            query.setParameter("id", id);
            retEstateType=(EstateType) query.getSingleResult();
            log.info("Get estate type by id");
        }
        catch (Exception ex){
            retEstateType=null;
            log.error(("Get estate type error: "+ ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
        return retEstateType;
    }

    public List<EstateType> getAll(){
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<EstateType> estateTypes=new LinkedList<>();

        try{
            String jql="SELECT e FROM EstateType e";
            estateTypes.addAll((session.createQuery(jql,EstateType.class).getResultList()));
            log.info("Get all estate types");
        }
        catch (Exception ex){
            log.error("Get Estate type error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return estateTypes;
    }

    public EstateType getByName(String name){
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();

        EstateType retEstateType;

        try{
            String jql= "SELECT u FROM EstateType u WHERE type=:name";
            Query query=session.createQuery(jql, EstateType.class);
            query.setParameter("name", name);
            retEstateType=(EstateType) query.getSingleResult();
            log.info("Get estate type by name");
        }
        catch (Exception ex){
            retEstateType=null;
            log.error(("Get estate type error: "+ ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
        return retEstateType;
    }
}
