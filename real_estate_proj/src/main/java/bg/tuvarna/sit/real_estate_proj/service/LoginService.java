package bg.tuvarna.sit.real_estate_proj.service;

import bg.tuvarna.sit.real_estate_proj.data.entities.User;
import bg.tuvarna.sit.real_estate_proj.data.repositories.UserRepository;

public class LoginService {
    private UserRepository userRepo = new UserRepository();

    public void setUserRepo(UserRepository userRepo)
    {
        this.userRepo = userRepo;
    }

    public User validateUserLogin(String username, String password)
    {
        User user = userRepo.getByUsername(username);
        if (user != null)
        {
            if (user.getPassword().equals(password))
            {
                return user;
            }
            return null;
        }
        return null;
    }
}
