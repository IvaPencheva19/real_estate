package bg.tuvarna.sit.real_estate_proj.presentation.controllers;

import bg.tuvarna.sit.real_estate_proj.data.entities.RealEstate;
import bg.tuvarna.sit.real_estate_proj.presentation.models.RealEstateModel;
import bg.tuvarna.sit.real_estate_proj.service.RealEstateService;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class ViewAllEstatesBrokerController {
    @FXML
    private TableView estatesTable;
    @FXML
    private TableColumn idCol;

    @FXML
    private TableColumn ownerCol;
    @FXML
    private TableColumn typeCol;
    @FXML
    private TableColumn areaCol;
    @FXML
    private TableColumn priceCol;
    @FXML
    private TableColumn currencyCol;
    @FXML
    private TableColumn cityCol;
    @FXML
    private TableColumn addressCol;
    @FXML
    private TableColumn floorsCol;
    @FXML
    private TableColumn roomsCol;
    @FXML
    private TableColumn descriptionCol;
    @FXML
    private TableColumn statusCol;

    private RealEstateService estateService=RealEstateService.getInstance();
    private RealEstateModel estateModel;
    public void loadTable(){
        idCol.setCellValueFactory(new PropertyValueFactory<>("idEstate"));
        ownerCol.setCellValueFactory(new PropertyValueFactory<>("estateOwner"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("estateType"));
        areaCol.setCellValueFactory(new PropertyValueFactory<>("estateArea"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("estatePrice"));
        currencyCol.setCellValueFactory(new PropertyValueFactory<>("estateCurrency"));
        cityCol.setCellValueFactory(new PropertyValueFactory<>("estateCity"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("estateAddress"));
        floorsCol.setCellValueFactory(new PropertyValueFactory<>("estateFloors"));
        roomsCol.setCellValueFactory(new PropertyValueFactory<>("estateRooms"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("estateDescription"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("estateStatus"));

        List<RealEstate> estates=estateService.getAllEstates();
        for(RealEstate estate:estates){
            estateModel=new RealEstateModel(estate);
            estatesTable.getItems().add(estateModel);
        }
    }
}
