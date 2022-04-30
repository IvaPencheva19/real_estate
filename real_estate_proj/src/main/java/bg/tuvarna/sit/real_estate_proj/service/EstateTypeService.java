package bg.tuvarna.sit.real_estate_proj.service;
import bg.tuvarna.sit.real_estate_proj.data.entities.Customer;
import bg.tuvarna.sit.real_estate_proj.data.entities.EstateCity;
import bg.tuvarna.sit.real_estate_proj.data.entities.EstateType;
import bg.tuvarna.sit.real_estate_proj.data.entities.RealEstate;
import bg.tuvarna.sit.real_estate_proj.data.repositories.EstateTypeRepository;

import java.util.List;

public class EstateTypeService {
    private final EstateTypeRepository repository=EstateTypeRepository.getInstance();

    public static EstateTypeService getInstance() {
        return EstateTypeService.UserHolder.INSTANCE;
    }

    private static class UserHolder {
        public static final EstateTypeService INSTANCE = new EstateTypeService();
    }
    public void createEstateType(EstateType type){
        repository.save(type);
    }
    public void deleteEstateType(EstateType type){
        repository.delete(type);
    }
    public void changeType(EstateType type, String name){
        type.setType(name);
        repository.update(type);
    }

    public List<EstateType> getAllTypes(){
        return repository.getAll();
    }
    public EstateType getTypeById(int id){
        EstateType type=repository.getById(id);
        return type;
    }
    public EstateType getTypeByName(String name){
        EstateType type=repository.getByName(name);
        return type;
    }
}
