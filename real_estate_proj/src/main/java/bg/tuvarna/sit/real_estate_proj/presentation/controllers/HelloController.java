package bg.tuvarna.sit.real_estate_proj.presentation.controllers;

import bg.tuvarna.sit.real_estate_proj.data.entities.User;
import bg.tuvarna.sit.real_estate_proj.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.real_estate_proj.presentation.FormActions.LoadUserController;
import bg.tuvarna.sit.real_estate_proj.presentation.FormActions.OpenForm;
import bg.tuvarna.sit.real_estate_proj.service.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {
    private LoginService loginService=new LoginService();

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label error;
    public static User user;
    @FXML
    private void userLogIn(ActionEvent event){

        String uname = this.username.getText();
        String pass = this.password.getText();

        user = loginService.validateUserLogin(uname, pass);
        if (user != null)
        {
            String name=user.getUsername();
            LoadUserController.loadController(user);
            CloseForm.closeForm(event);

        } else
        {
            error.setText("Wrong username or password");
            this.username.clear();
            this.password.clear();
            this.username.requestFocus();
        }
    }
}