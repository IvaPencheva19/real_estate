package bg.tuvarna.sit.real_estate_proj.presentation.controllers;

import bg.tuvarna.sit.real_estate_proj.data.entities.Broker;
import bg.tuvarna.sit.real_estate_proj.data.entities.RealEstate;
import bg.tuvarna.sit.real_estate_proj.data.entities.Sale;
import bg.tuvarna.sit.real_estate_proj.presentation.models.RealEstateModel;
import bg.tuvarna.sit.real_estate_proj.presentation.models.SaleModel;
import bg.tuvarna.sit.real_estate_proj.service.RealEstateService;
import bg.tuvarna.sit.real_estate_proj.service.SaleService;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class ViewAllSalesController {

    @FXML
    private TableView tableSales;
    @FXML
    private TableColumn idSale;

    @FXML
    private TableColumn customerName;
    @FXML
    private TableColumn customerPhone;
    @FXML
    private TableColumn customerAddress;
    @FXML
    private TableColumn estateId;
    @FXML
    private TableColumn contractNumber;


    private SaleService saleService=SaleService.getInstance();
    private SaleModel saleModel;
    public void loadTable(){
        idSale.setCellValueFactory(new PropertyValueFactory<>("idSale"));
        customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        customerPhone.setCellValueFactory(new PropertyValueFactory<>("customerPhone"));
        customerAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        estateId.setCellValueFactory(new PropertyValueFactory<>("estateId"));
        contractNumber.setCellValueFactory(new PropertyValueFactory<>("contractNumber"));


        List<Sale> sales=saleService.getAllSalesByBroker((Broker)HelloController.user);
        for(Sale sale:sales){
            saleModel=new SaleModel(sale);
            tableSales.getItems().add(saleModel);
        }
    }
}
