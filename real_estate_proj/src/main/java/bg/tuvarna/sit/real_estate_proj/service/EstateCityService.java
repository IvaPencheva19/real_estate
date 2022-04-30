package bg.tuvarna.sit.real_estate_proj.service;
import bg.tuvarna.sit.real_estate_proj.data.entities.Customer;
import bg.tuvarna.sit.real_estate_proj.data.entities.EstateCity;
import bg.tuvarna.sit.real_estate_proj.data.entities.RealEstate;
import bg.tuvarna.sit.real_estate_proj.data.repositories.EstateCityRepository;

import java.util.List;

public class EstateCityService {
    private final EstateCityRepository repository=EstateCityRepository.getInstance();

    public static EstateCityService getInstance() {
        return EstateCityService.UserHolder.INSTANCE;
    }

    private static class UserHolder {
        public static final EstateCityService INSTANCE = new EstateCityService();
    }
    public void createEstateCity(EstateCity city){
        repository.save(city);
    }
    public void deleteEstateCity(EstateCity city){
        repository.delete(city);
    }
    public void changeCityName(EstateCity city, String name){
        city.setCity(name);
        repository.update(city);
    }

    public List<EstateCity> getAllCities(){
        return repository.getAll();
    }
    public EstateCity getCityById(int id){
        EstateCity city=repository.getById(id);
        return city;
    }
    public EstateCity getCityByName(String name){
        EstateCity city=repository.getByName(name);
        return city;
    }

}
