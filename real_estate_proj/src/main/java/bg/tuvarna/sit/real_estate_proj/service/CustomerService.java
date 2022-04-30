package bg.tuvarna.sit.real_estate_proj.service;
import bg.tuvarna.sit.real_estate_proj.data.entities.Broker;
import bg.tuvarna.sit.real_estate_proj.data.entities.Customer;
import bg.tuvarna.sit.real_estate_proj.data.entities.Sale;
import bg.tuvarna.sit.real_estate_proj.data.repositories.CustomerRepository;

import java.util.List;


public class CustomerService {
    private final CustomerRepository repository =CustomerRepository.getInstance();

    public static CustomerService getInstance() {
        return CustomerService.UserHolder.INSTANCE;
    }

    private static class UserHolder {
        public static final CustomerService INSTANCE = new CustomerService();
    }
    public void createCustomer(Customer cus){
        repository.save(cus);
    }
    public void deleteCustomer(Customer cus){
        repository.delete(cus);
    }
    public void changeName(Customer cus, String name){
        cus.setName(name);
        repository.update(cus);
    }
    public void changePhone(Customer cus, String phone){
        cus.setPhone(phone);
        repository.update(cus);
    }
    public void changeAddress(Customer cus, String address){
        cus.setAddress(address);
        repository.update(cus);
    }

   public List<Customer> getAllCustomers(){
        return repository.getAll();
   }

}
