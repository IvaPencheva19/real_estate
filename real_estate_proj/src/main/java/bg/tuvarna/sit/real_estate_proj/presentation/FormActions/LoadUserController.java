package bg.tuvarna.sit.real_estate_proj.presentation.FormActions;

import bg.tuvarna.sit.real_estate_proj.data.entities.Administrator;
import bg.tuvarna.sit.real_estate_proj.data.entities.Broker;
import bg.tuvarna.sit.real_estate_proj.data.entities.User;
import bg.tuvarna.sit.real_estate_proj.presentation.controllers.AdminAccountController;
import bg.tuvarna.sit.real_estate_proj.presentation.controllers.BrokerAccountController;
import bg.tuvarna.sit.real_estate_proj.presentation.controllers.HelloController;
import bg.tuvarna.sit.real_estate_proj.presentation.controllers.MenuAdminController;
import javafx.fxml.FXMLLoader;

public class LoadUserController {
    private static FXMLLoader loader;
    public static void loadController(User user)
    {
        if (user instanceof Administrator) {
            loader = OpenForm.openNewForm("AdminAccountForm.fxml", "Admin");
            AdminAccountController next=loader.getController();
           // next.getMenuController().setUser();

        }
        if (user instanceof Broker) {
            loader = OpenForm.openNewForm("BrokerAccountForm.fxml", "Broker");
            BrokerAccountController next = loader.getController();
        }
        //next.setUser(this);
    }
}
