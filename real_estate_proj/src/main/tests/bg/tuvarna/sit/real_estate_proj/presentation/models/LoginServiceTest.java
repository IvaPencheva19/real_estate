package bg.tuvarna.sit.real_estate_proj.presentation.models;

import bg.tuvarna.sit.real_estate_proj.data.entities.User;
import bg.tuvarna.sit.real_estate_proj.service.LoginService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LoginServiceTest {
    LoginService lserv=new LoginService();
    @Test
    void testValidateUserLoginTrue(){
        User user= lserv.validateUserLogin("ivan222","ivan222");
        assertNotNull(user);
    }
    @Test
    void testValidateUserLoginFalse(){
        User user= lserv.validateUserLogin("ivan","222");
        assertNull(user);
    }
}
