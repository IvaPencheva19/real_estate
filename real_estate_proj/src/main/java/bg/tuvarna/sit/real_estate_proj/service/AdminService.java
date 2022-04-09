package bg.tuvarna.sit.real_estate_proj.service;

import bg.tuvarna.sit.real_estate_proj.data.entities.Administrator;
import bg.tuvarna.sit.real_estate_proj.data.entities.RealEstate;
import bg.tuvarna.sit.real_estate_proj.data.repositories.UserRepository;

public class AdminService {
    private final UserRepository repository = UserRepository.getInstance();

    public static AdminService getInstance() {
        return AdminService.UserHolder.INSTANCE;
    }

    private static class UserHolder {
        public static final AdminService INSTANCE = new AdminService();
    }
    public void createAdmin(Administrator admin){
        repository.save(admin);
    }
    public void deleteAdmin(Administrator admin){
        repository.delete(admin);
    }
    public void changeUserName(Administrator adm, String username){
        adm.setUsername(username);
        repository.update(adm);
    }

    public void changePassword(Administrator adm, String password){
        adm.setPassword(password);
        repository.update(adm);
    }

    public void changeFirstName(Administrator adm, String firstName){
        adm.setFirstname(firstName);
        repository.update(adm);
    }

    public void changeLastName(Administrator adm, String lastName){
        adm.setLastname(lastName);
        repository.update(adm);
    }
    public void changePhone(Administrator adm, String phone){
        adm.setPhone(phone);
        repository.update(adm);
    }
    public void changeEmail(Administrator adm, String email) {
        adm.setEmail(email);
        repository.update(adm);
    }
    public void addEstate(Administrator adm, RealEstate estate) {
        adm.getEstates().add(estate);
        repository.update(adm);
    }
    public void removeEstate(Administrator adm, RealEstate estate) {
        adm.getEstates().remove(estate);
        repository.update(adm);
    }

}
