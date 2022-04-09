package bg.tuvarna.sit.real_estate_proj.service;

import bg.tuvarna.sit.real_estate_proj.data.repositories.UserRepository;

public class UserService {
    private final UserRepository repository = UserRepository.getInstance();

    public static UserService getInstance() {
        return UserService.UserHolder.INSTANCE;
    }

    private static class UserHolder {
        public static final UserService INSTANCE = new UserService();
    }

}
