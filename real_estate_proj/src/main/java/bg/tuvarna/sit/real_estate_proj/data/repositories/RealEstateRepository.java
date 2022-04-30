package bg.tuvarna.sit.real_estate_proj.data.repositories;

import bg.tuvarna.sit.real_estate_proj.data.access.Connection;
import bg.tuvarna.sit.real_estate_proj.data.entities.EstateCity;
import bg.tuvarna.sit.real_estate_proj.data.entities.EstateCurrency;
import bg.tuvarna.sit.real_estate_proj.data.entities.EstateType;
import bg.tuvarna.sit.real_estate_proj.data.entities.RealEstate;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.lang.reflect.Type;
import java.util.Currency;
import java.util.LinkedList;
import java.util.List;

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

    public List<RealEstate> getAll(){
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<RealEstate> realEstates=new LinkedList<>();

        try{
            String jql="SELECT r FROM RealEstate r";
            realEstates.addAll((session.createQuery(jql,RealEstate.class).getResultList()));
            log.info("Get all real estates");
        }
        catch (Exception ex){
            log.error("Get Real estate error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return realEstates;
    }

    public List<RealEstate> getByOwner(String name) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<RealEstate> realEstates=new LinkedList<>();

        try {
            String jql = "SELECT u FROM RealEstate u WHERE estateOwner = :name";
            realEstates.addAll((session.createQuery(jql,RealEstate.class).setParameter("name", name).getResultList()));
            log.info("Get type by name");
        }
        catch (Exception ex){

            log.error("Get estate error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return realEstates;
    }
    public List<RealEstate> getByArea(Double name) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<RealEstate> realEstates=new LinkedList<>();

        try {
            String jql = "SELECT u FROM RealEstate u WHERE estateArea < :name";
            realEstates.addAll((session.createQuery(jql,RealEstate.class).setParameter("name", name).getResultList()));
            log.info("Get estate by area");
        }
        catch (Exception ex){
            log.error("Get estate error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return realEstates;
    }

    public List<RealEstate> getByPrice(Double name) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<RealEstate> realEstates=new LinkedList<>();

        try {
            String jql = "SELECT u FROM RealEstate u WHERE estatePrice < :name";
            realEstates.addAll((session.createQuery(jql,RealEstate.class).setParameter("name", name).getResultList()));
            log.info("Get estate by area");
        }
        catch (Exception ex){
            log.error("Get estate error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return realEstates;
    }
    public List<RealEstate> getByAddress(String name) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<RealEstate> realEstates=new LinkedList<>();

        try {
            String jql = "SELECT u FROM RealEstate u WHERE estateAddress = :name";
            realEstates.addAll((session.createQuery(jql,RealEstate.class).setParameter("name", name).getResultList()));
            log.info("Get estate by address");
        }
        catch (Exception ex){
            log.error("Get estate error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return realEstates;
    }
    public List<RealEstate> getByFloors(Integer name) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<RealEstate> realEstates=new LinkedList<>();

        try {
            String jql = "SELECT u FROM RealEstate u WHERE estateFloors = :name";
            realEstates.addAll((session.createQuery(jql,RealEstate.class).setParameter("name", name).getResultList()));
            log.info("Get estate by floors");
        }
        catch (Exception ex){
            log.error("Get estate error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return realEstates;
    }
    public List<RealEstate> getByRooms(Integer name) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<RealEstate> realEstates=new LinkedList<>();

        try {
            String jql = "SELECT u FROM RealEstate u WHERE estateRooms = :name";
            realEstates.addAll((session.createQuery(jql,RealEstate.class).setParameter("name", name).getResultList()));
            log.info("Get estate by rooms");
        }
        catch (Exception ex){
            log.error("Get estate error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return realEstates;
    }
    public List<RealEstate> getByStatus(Byte name) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<RealEstate> realEstates=new LinkedList<>();

        try {
            String jql = "SELECT u FROM RealEstate u WHERE estateStatus = :name";
            realEstates.addAll((session.createQuery(jql,RealEstate.class).setParameter("name", name).getResultList()));
            log.info("Get estate by address");
        }
        catch (Exception ex){
            log.error("Get estate error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return realEstates;
    }

    public List<RealEstate> getByType(EstateType name) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<RealEstate> realEstates=new LinkedList<>();

        try {
            String jql = "SELECT u FROM RealEstate u WHERE estateType = :name";
            realEstates.addAll((session.createQuery(jql,RealEstate.class).setParameter("name", name).getResultList()));
            log.info("Get estate by address");
        }
        catch (Exception ex){
            log.error("Get estate error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return realEstates;
    }
    public List<RealEstate> getByCurrency(EstateCurrency name) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<RealEstate> realEstates=new LinkedList<>();

        try {
            String jql = "SELECT u FROM RealEstate u WHERE estateCurrency = :name";
            realEstates.addAll((session.createQuery(jql,RealEstate.class).setParameter("name", name).getResultList()));
            log.info("Get estate by address");
        }
        catch (Exception ex){
            log.error("Get estate error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return realEstates;
    }

    public List<RealEstate> getByCity(EstateCity name) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<RealEstate> realEstates=new LinkedList<>();

        try {
            String jql = "SELECT u FROM RealEstate u WHERE estateCity = :name";
            realEstates.addAll((session.createQuery(jql,RealEstate.class).setParameter("name", name).getResultList()));
            log.info("Get estate by address");
        }
        catch (Exception ex){
            log.error("Get estate error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return realEstates;
    }

}
