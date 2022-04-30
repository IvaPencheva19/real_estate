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
    public void changeEstateArea(RealEstate estate, Double area) {
        estate.setEstateArea(area);
        repository.update(estate);
    }
        public void changeEstatePrice(RealEstate estate, Double price){
            estate.setEstatePrice(price);
            repository.update(estate);
    }
    public void changeEstateCurrency(RealEstate estate, EstateCurrency currency){
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
        repository.update(estate);}

        public void changeEstateRooms(RealEstate estate, Integer rooms){
            estate.setEstateRooms(rooms);
            repository.update(estate);
    }
    public void changeEstateDescription(RealEstate estate, String desc){
        estate.setEstateDescription(desc);
        repository.update(estate);
    }
    public void changeEstateStatus(RealEstate estate, Byte status){
        estate.setEstateStatus(status);
        repository.update(estate);
    }

    public List<RealEstate> getAllEstates(){
        return repository.getAll();
    }
    public RealEstate getById(Integer id){
        return repository.getById(id);
    }
    public List<RealEstate> getAllEstatesByOwner(String owner){
        return repository.getByOwner(owner);
    }
    public List<RealEstate> getAllEstatesByArea(Double area){
        return repository.getByArea(area);
    }
    public List<RealEstate> getAllEstatesByPrice(Double price){
        return repository.getByPrice(price);
    }
    public List<RealEstate> getAllEstatesByAddress(String address){
        return repository.getByAddress(address);
    }
    public List<RealEstate> getAllEstatesByFloors(Integer floors){
        return repository.getByFloors(floors);
    }
    public List<RealEstate> getAllEstatesByRooms(Integer rooms){
        return repository.getByRooms(rooms);
    }
    public List<RealEstate> getAllEstatesByStatus(Byte status){
        return repository.getByStatus(status);
    }

    public List<RealEstate> getAllEstatesByType(EstateType type){
        return repository.getByType(type);
    }

    public List<RealEstate> getAllEstatesByCurrency(EstateCurrency currency){
        return repository.getByCurrency(currency);
    }
    public List<RealEstate> getAllEstatesByCity(EstateCity city){
        return repository.getByCity(city);
    }


}
