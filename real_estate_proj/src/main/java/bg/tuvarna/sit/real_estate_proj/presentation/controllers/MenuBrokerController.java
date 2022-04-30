package bg.tuvarna.sit.real_estate_proj.presentation.controllers;

import bg.tuvarna.sit.real_estate_proj.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.real_estate_proj.presentation.FormActions.OpenForm;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

public class MenuBrokerController {
    private FXMLLoader loader;
    public void viewAllEstates(ActionEvent event){
        loader = OpenForm.openNewForm("ViewAllEstateBrokerForm.fxml", "View all estates");
        ViewAllEstatesBrokerController next = loader.getController();
        next.loadTable();
        CloseForm.closeForm(event);
    }
    public void searchEstate(ActionEvent event){
        loader = OpenForm.openNewForm("SearchEstateForm.fxml", "Search estate");
        SearchEstateController next = loader.getController();
        next.loadCombo();
        next.setPropertyTable();
        CloseForm.closeForm(event);
    }
    public void sellEstate(ActionEvent event){
        loader = OpenForm.openNewForm("SellEstateForm.fxml", "Sell estate");
        SellEstateController next = loader.getController();
        //next.loadCombo();
        //next.setPropertyTable();
        CloseForm.closeForm(event);
    }
    public void viewAllSales(ActionEvent event){
        loader = OpenForm.openNewForm("ViewAllSalesForm.fxml", "View all sales");
        ViewAllSalesController next = loader.getController();
        next.loadTable();
        //next.setPropertyTable();
        CloseForm.closeForm(event);
    }
    public void logOut(ActionEvent event){
        loader = OpenForm.openNewForm("hello-view.fxml", "Login");
        CloseForm.closeForm(event);
        HelloController.user=null;
    }
}
