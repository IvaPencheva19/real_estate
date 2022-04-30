package bg.tuvarna.sit.real_estate_proj.presentation.controllers;

import bg.tuvarna.sit.real_estate_proj.data.entities.Broker;
import bg.tuvarna.sit.real_estate_proj.data.entities.Customer;
import bg.tuvarna.sit.real_estate_proj.data.entities.RealEstate;
import bg.tuvarna.sit.real_estate_proj.data.entities.Sale;
import bg.tuvarna.sit.real_estate_proj.service.BrokerService;
import bg.tuvarna.sit.real_estate_proj.service.CustomerService;
import bg.tuvarna.sit.real_estate_proj.service.RealEstateService;
import bg.tuvarna.sit.real_estate_proj.service.SaleService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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
                Customer customer = new Customer(cusName, cusPhone, cusAddress);
                customerService.createCustomer(customer);
                Sale sale = new Sale(contrNumber, estate, customer, (Broker) HelloController.user);
                saleService.createSale(sale);
                Byte statusValue = 0;
                realEstateServiceService.changeEstateStatus(estate, statusValue);

            }
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
