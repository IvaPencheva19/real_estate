package bg.tuvarna.sit.real_estate_proj.presentation.controllers;

import bg.tuvarna.sit.real_estate_proj.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.real_estate_proj.presentation.FormActions.OpenForm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

public class MenuAdminController {
    private FXMLLoader loader;
    @FXML
    private Label nameUser;



    public void addBroker(ActionEvent event){
    loader = OpenForm.openNewForm("AddBrokerForm.fxml", "Add Broker");
   AddBrokerController next = loader.getController();
        CloseForm.closeForm(event);
    }
    public void logOut(ActionEvent event){
        loader = OpenForm.openNewForm("hello-view.fxml", "Login");
        CloseForm.closeForm(event);
        HelloController.user=null;
    }
    public void setUser() {
        nameUser.setText(HelloController.user.getUsername());
    }

    public MenuAdminController() {}
}
