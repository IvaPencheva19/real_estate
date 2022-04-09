package bg.tuvarna.sit.real_estate_proj.service;
import bg.tuvarna.sit.real_estate_proj.data.entities.*;
import bg.tuvarna.sit.real_estate_proj.data.repositories.RealEstateRepository;

import java.util.List;

public class RealEstateService {
    private final RealEstateRepository repository=RealEstateRepository.getInstance();

    public static RealEstateService getInstance() {
        return RealEstateService.UserHolder.INSTANCE;
    }

    private static class UserHolder {
        public static final RealEstateService INSTANCE = new RealEstateService();
    }
    public void createRealEstate(RealEstate estate){
        repository.save(estate);
    }
    public void deleteRealEstate(RealEstate estate){
        repository.delete(estate);
    }
    public void changeEstateOwner(RealEstate estate, String name){
       estate.setEstateOwner(name);
        repository.update(estate);
    }
    public void changeEstateType(RealEstate estate, EstateType type){
        estate.setEstateType(type);
        repository.update(estate);
    }
    public void changeEstateArea(RealEstate estate, Double area){
        estate.setEstateArea(area);
        repository.update(estate);
    }
    public void changeEstateArea(RealEstate estate, EstateCurrency currency){
        estate.setEstateCurrency(currency);
        repository.update(estate);
    }
    public void changeEstateCity(RealEstate estate, EstateCity city){
        estate.setEstateCity(city);
        repository.update(estate);
    }
    public void changeEstateAddress(RealEstate estate, String address){
        estate.setEstateAddress(address);
        repository.update(estate);
    }
    public void changeEstateFloors(RealEstate estate, Integer floors){
        estate.setEstateFloors(floors);
        repository.update(estate);
    }
    public void changeEstateStatus(RealEstate estate, Byte status){
        estate.setEstateStatus(status);
        repository.update(estate);
    }
    public void addSale(RealEstate estate, Sale sale) {
        estate.getSales().add(sale);
        repository.update(estate);
    }
    public List<RealEstate> getAllEstates(){
        return repository.getAll();
    }

}
