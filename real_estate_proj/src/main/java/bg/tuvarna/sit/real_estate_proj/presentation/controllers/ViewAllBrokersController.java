package bg.tuvarna.sit.real_estate_proj.presentation.controllers;

import bg.tuvarna.sit.real_estate_proj.data.entities.Broker;
import bg.tuvarna.sit.real_estate_proj.data.entities.RealEstate;
import bg.tuvarna.sit.real_estate_proj.presentation.models.BrokerModel;
import bg.tuvarna.sit.real_estate_proj.presentation.models.RealEstateModel;
import bg.tuvarna.sit.real_estate_proj.service.BrokerService;
import bg.tuvarna.sit.real_estate_proj.service.RealEstateService;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class ViewAllBrokersController {
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
    private TableView tableBrokers;

    private BrokerService brokerService=BrokerService.getInstance();
    private BrokerModel brokerModel;
    public void loadTable(){

        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        List<Broker> brokers=brokerService.getAllBrokers();
        for(Broker broker:brokers){
            brokerModel=new BrokerModel(broker);
            tableBrokers.getItems().add(brokerModel);

        }

    }

}
