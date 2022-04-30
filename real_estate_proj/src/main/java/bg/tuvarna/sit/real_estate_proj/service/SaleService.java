package bg.tuvarna.sit.real_estate_proj.service;
import bg.tuvarna.sit.real_estate_proj.data.entities.Broker;
import bg.tuvarna.sit.real_estate_proj.data.entities.Customer;
import bg.tuvarna.sit.real_estate_proj.data.entities.RealEstate;
import bg.tuvarna.sit.real_estate_proj.data.entities.Sale;
import bg.tuvarna.sit.real_estate_proj.data.repositories.SaleRepository;

import java.util.List;

public class SaleService {
    private final SaleRepository repository=SaleRepository.getInstance();

    public static SaleService getInstance() {
        return SaleService.UserHolder.INSTANCE;
    }

    private static class UserHolder {
        public static final SaleService INSTANCE = new SaleService();
    }
    public void createSale(Sale sale){
        repository.save(sale);
    }
    public void deleteSale(Sale sale){
        repository.delete(sale);
    }
    public void changeContract(Sale sale, String contract){
        sale.setContract(contract);
        repository.update(sale);
    }
    public void changeRealEstate(Sale sale, RealEstate estate){
        sale.setEstate(estate);
        repository.update(sale);
    }
    public void changeCustomer(Sale sale, Customer customer){
        sale.setCustomer(customer);
        repository.update(sale);
    }
    public List<Sale> getAllSales(){
        return repository.getAll();
    }
    public List<Sale> getAllSalesByBroker(Broker broker){
        return repository.getSalesByBroker(broker);
    }

}
