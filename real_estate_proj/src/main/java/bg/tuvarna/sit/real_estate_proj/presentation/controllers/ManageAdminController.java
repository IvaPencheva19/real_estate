package bg.tuvarna.sit.real_estate_proj.presentation.controllers;

import bg.tuvarna.sit.real_estate_proj.data.entities.Administrator;
import bg.tuvarna.sit.real_estate_proj.data.entities.Broker;
import bg.tuvarna.sit.real_estate_proj.presentation.models.AdminModel;
import bg.tuvarna.sit.real_estate_proj.presentation.models.BrokerModel;
import bg.tuvarna.sit.real_estate_proj.service.AdminService;
import bg.tuvarna.sit.real_estate_proj.service.BrokerService;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class ManageAdminController {
    @FXML
    private TableColumn usernameCol;
    @FXML
    private TableColumn firstNameCol;
    @FXML
    private TableColumn lastNameCol;
    @FXML
    private TableColumn phoneCol;
    @FXML
    private TableColumn emailCol;
    @FXML
    private TableView tableAdmins;

    private AdminService adminService=AdminService.getInstance();
    private AdminModel adminModel;
    public void loadTable(){

        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        List<Administrator> administrators=adminService.getAllAdministrators();
        for(Administrator admin:administrators){
            adminModel=new AdminModel(admin);
            tableAdmins.getItems().add(adminModel);

        }
    }
}
