package bg.tuvarna.sit.real_estate_proj.presentation.controllers;

import bg.tuvarna.sit.real_estate_proj.data.entities.Administrator;
import bg.tuvarna.sit.real_estate_proj.presentation.FormActions.ShowWarning;
import bg.tuvarna.sit.real_estate_proj.service.AdminService;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AddAdminController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField repeatPassword;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField phone;
    @FXML
    private TextField email;
    private AdminService adminService=AdminService.getInstance();
    public void addAdmin(){
        String uname=username.getText();
        String pass1=password.getText();
        String pass2=repeatPassword.getText();
        String fName=firstName.getText();
        String lName=lastName.getText();
        String ph=phone.getText();
        String em=email.getText();
        if (!pass1.equals(pass2)){
            ShowWarning.showWarning("Passwords are different");
            password.clear();
            repeatPassword.clear();
        }
        else if(uname.equals("")|| pass1.equals("")||pass2.equals("")||fName.equals("")
                ||lName.equals("")||ph.equals("")||em.equals("")){
            ShowWarning.showWarning("Empty field(s)");
        }
        else{
            Administrator admin=new Administrator(uname,pass1,fName,lName,ph,em);
            adminService.createAdmin(admin);
            ShowWarning.showInformation("Successfully added admin");
            clearFields();
        }



    }
    private void clearFields(){
        username.clear();
        password.clear();
        repeatPassword.clear();
        firstName.clear();
        lastName.clear();
        phone.clear();
        email.clear();
    }
}
