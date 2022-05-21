package bg.tuvarna.sit.real_estate_proj.presentation.controllers;

import bg.tuvarna.sit.real_estate_proj.data.entities.Broker;
import bg.tuvarna.sit.real_estate_proj.data.entities.Customer;
import bg.tuvarna.sit.real_estate_proj.data.entities.RealEstate;
import bg.tuvarna.sit.real_estate_proj.data.entities.Sale;
import bg.tuvarna.sit.real_estate_proj.presentation.FormActions.ShowWarning;
import bg.tuvarna.sit.real_estate_proj.service.BrokerService;
import bg.tuvarna.sit.real_estate_proj.service.CustomerService;
import bg.tuvarna.sit.real_estate_proj.service.RealEstateService;
import bg.tuvarna.sit.real_estate_proj.service.SaleService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.Optional;

public class SellEstateController {
    @FXML
    private TextField customerName;
    @FXML
    private TextField customerPhone;
    @FXML
    private TextField customerAddress;
    @FXML
    private TextField estateId;
    @FXML
    private TextField contractNumber;

    private CustomerService customerService=CustomerService.getInstance();
    private RealEstateService realEstateServiceService=RealEstateService.getInstance();
    private SaleService saleService=SaleService.getInstance();
    private BrokerService brokerService=BrokerService.getInstance();
    public void sellEstate(){
        String cusName = customerName.getText();
        String cusPhone = customerPhone.getText();
        String cusAddress = customerAddress.getText();
        Integer estId=Integer.parseInt(estateId.getText());
        RealEstate estate=realEstateServiceService.getById(estId);
        String contrNumber = contractNumber.getText();
        if(estate!=null) {
            if (estate.getEstateStatus() == 1) {
              if (saleService.checkContract(contrNumber)) {
                  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                  alert.setTitle("Deleting");
                  String s = "Confirm to sell broker " + estId;
                  alert.setContentText(s);

                  Optional<ButtonType> result = alert.showAndWait();

                  if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                      Customer customer = new Customer(cusName, cusPhone, cusAddress);
                      customerService.createCustomer(customer);
                      Sale sale = new Sale(contrNumber, estate, customer, (Broker) HelloController.user);
                      saleService.createSale(sale);
                      Byte statusValue = 0;
                      realEstateServiceService.changeEstateStatus(estate, statusValue);
                  }
              }
              else{
                  ShowWarning.showWarning("There is other sale with this contract!");
              }

            }
            else{
                ShowWarning.showWarning("This is estate is SOLD!");
            }

        }
        else{
            ShowWarning.showWarning("No such estate!");
        }
        clearFields();
    }
    public void clearFields(){
        customerName.clear();
        customerPhone.clear();
        customerAddress.clear();
        estateId.clear();
        contractNumber.clear();
    }


}
