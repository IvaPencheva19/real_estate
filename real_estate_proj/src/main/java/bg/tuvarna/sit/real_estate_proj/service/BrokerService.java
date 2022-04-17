package bg.tuvarna.sit.real_estate_proj.service;

import bg.tuvarna.sit.real_estate_proj.data.entities.Administrator;
import bg.tuvarna.sit.real_estate_proj.data.entities.Broker;
import bg.tuvarna.sit.real_estate_proj.data.entities.RealEstate;
import bg.tuvarna.sit.real_estate_proj.data.entities.Sale;
import bg.tuvarna.sit.real_estate_proj.data.repositories.UserRepository;

import java.util.List;

public class BrokerService {
    private final UserRepository repository = UserRepository.getInstance();

    public static BrokerService getInstance() {
        return BrokerService.UserHolder.INSTANCE;
    }

    private static class UserHolder {
        public static final BrokerService INSTANCE = new BrokerService();
    }
    public void createBroker(Broker broker){
        repository.save(broker);
    }
    public void deleteBroker(Broker broker){
        repository.delete(broker);
    }
    public void changeUserName(Broker broker, String username){
        broker.setUsername(username);
        repository.update(broker);
    }

    public void changePassword(Broker broker, String password){
        broker.setPassword(password);
        repository.update(broker);
    }

    public void changeFirstName(Broker broker, String firstName){
        broker.setFirstname(firstName);
        repository.update(broker);
    }

    public void changeLastName(Broker broker, String lastName){
        broker.setLastname(lastName);
        repository.update(broker);
    }
    public void changePhone(Broker broker, String phone){
        broker.setPhone(phone);
        repository.update(broker);
    }
    public void changeEmail(Broker broker, String email) {
        broker.setEmail(email);
        repository.update(broker);
    }
    public void addSale(Broker broker, Sale sale) {
        broker.getSales().add(sale);
        repository.update(broker);
    }
    public void removeSale(Broker broker, Sale sale) {
        broker.getSales().remove(sale);
        repository.update(broker);
    }
    public List<Broker> getAllBrokers(){
       return repository.getAllBrokers();
    }
    public Broker getByUsername(String username){
        return (Broker)repository.getByUsername(username);
    }

}
