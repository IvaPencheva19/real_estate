package bg.tuvarna.sit.real_estate_proj.presentation.controllers;

import bg.tuvarna.sit.real_estate_proj.data.entities.Broker;
import bg.tuvarna.sit.real_estate_proj.presentation.FormActions.ShowWarning;
import bg.tuvarna.sit.real_estate_proj.presentation.models.BrokerModel;
import bg.tuvarna.sit.real_estate_proj.service.BrokerService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Optional;

public class UpdateDeleteBrokersController {
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
    @FXML
    private ComboBox comboCriterion;

    @FXML
    private TextField username;
    @FXML
    private TextField newVal;

    private String usernameVal;
    private Broker broker;

    private BrokerService brokerService=BrokerService.getInstance();
    private BrokerModel brokerModel;

    public void loadCombo(){
        comboCriterion.getItems().add("Username");
        comboCriterion.getItems().add("First Name");
        comboCriterion.getItems().add("Last Name");
        comboCriterion.getItems().add("Phone");
        comboCriterion.getItems().add("Email");
    }

    public void searchByUsername(){
        tableBrokers.getItems().clear();
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

         usernameVal=username.getText();
         broker=brokerService.getByUsername(usernameVal);
         if(broker==null){
             ShowWarning.showInformation("No such user");
         }
         else {
             brokerModel = new BrokerModel(broker);
             tableBrokers.getItems().add(brokerModel);
         }

    }
   public void updateBroker(){

       String comboVal=comboCriterion.getValue().toString();
       usernameVal=username.getText();

       broker=brokerService.getByUsername(usernameVal);
       if(broker==null){
           ShowWarning.showInformation("No such user");
       }else {
           String upd = newVal.getText();

           if (comboVal.equals("Username")) {
               brokerService.changeUserName(broker, upd);
           }
           if (comboVal.equals("First Name")) {
               brokerService.changeFirstName(broker, upd);
           }
           if (comboVal.equals("Last Name")) {
               brokerService.changeLastName(broker, upd);
           }
           if (comboVal.equals("Phone")) {
               brokerService.changePhone(broker, upd);
           }
           if (comboVal.equals("Email")) {
               brokerService.changeEmail(broker, upd);
           }
           ShowWarning.showInformation("Successfull updating");
           clearFields();
       }
   }

    public void deleteBroker(){
        usernameVal=username.getText();
        broker=brokerService.getByUsername(usernameVal);
        if(broker==null){
            ShowWarning.showInformation("No such user");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Deleting");
            String s = "Confirm to delete broker "+usernameVal;
            alert.setContentText(s);

            Optional<ButtonType> result = alert.showAndWait();

            if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                brokerService.deleteBroker(broker);
                ShowWarning.showInformation("Successfull deleting");
                clearFields();

            }

        }
    }
    private void clearFields(){
        username.clear();
        newVal.clear();
        tableBrokers.getItems().clear();
    }


}
