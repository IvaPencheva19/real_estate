package bg.tuvarna.sit.real_estate_proj.presentation.controllers;

import bg.tuvarna.sit.real_estate_proj.data.entities.*;
import bg.tuvarna.sit.real_estate_proj.presentation.FormActions.ShowWarning;
import bg.tuvarna.sit.real_estate_proj.presentation.models.RealEstateModel;
import bg.tuvarna.sit.real_estate_proj.service.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class UpdateDeleteEstatesController {
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
    @FXML
    private ComboBox comboCriterion;
    @FXML
    private ComboBox comboNewValue;

    @FXML
    private TextField idEstate;
    @FXML
    private TextField newVal;

    private Integer idVal;
    private RealEstate estate;

    private RealEstateService estateService=RealEstateService.getInstance();
    private EstateTypeService typeService=EstateTypeService.getInstance();
    private EstateCityService cityService=EstateCityService.getInstance();
    private EstateCurrencyService currencyService=EstateCurrencyService.getInstance();
    private RealEstateModel realEstateModel;


    public void loadCombo(){
        comboCriterion.getItems().add("Owner");
        comboCriterion.getItems().add("Type");
        comboCriterion.getItems().add("Area");
        comboCriterion.getItems().add("Price");
        comboCriterion.getItems().add("Currency");
        comboCriterion.getItems().add("City");
        comboCriterion.getItems().add("Address");
        comboCriterion.getItems().add("Floors");
        comboCriterion.getItems().add("Rooms");
        comboCriterion.getItems().add("Description");
        comboCriterion.getItems().add("Status");

        comboNewValue.setVisible(false);
        comboCriterion.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                if(comboCriterion.getValue()=="Type"){
                    comboNewValue.setVisible(true);
                    newVal.setVisible(false);

                    List<EstateType> typeList=typeService.getAllTypes();
                    comboNewValue.getItems().clear();
                    for(EstateType typeVal:typeList){
                        comboNewValue.getItems().add(typeVal.getType());
                    }

                }
                else if(comboCriterion.getValue()=="Currency"){
                    comboNewValue.setVisible(true);
                    newVal.setVisible(false);
                    List<EstateCurrency> currencyList=currencyService.getAllCurrency();
                    comboNewValue.getItems().clear();
                    for(EstateCurrency currencyVal:currencyList){
                        comboNewValue.getItems().add(currencyVal.getCurrency());
                    }
                }
                else if(comboCriterion.getValue()=="City"){
                    comboNewValue.setVisible(true);
                    newVal.setVisible(false);
                    List<EstateCity> citiesList=cityService.getAllCities();
                    comboNewValue.getItems().clear();
                    for(EstateCity cityVal:citiesList){
                        comboNewValue.getItems().add(cityVal.getCity());
                    }
                }
                else{
                    comboNewValue.setVisible(false);
                    newVal.setVisible(true);
                }
            }
        });



    }





    public void searchEstateById(){
        estatesTable.getItems().clear();
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

        idVal=Integer.parseInt(idEstate.getText());
        estate=estateService.getById(idVal);
        if( estate==null){
            ShowWarning.showInformation("No such estate");
        }
        else {
            realEstateModel = new RealEstateModel(estate);
            estatesTable.getItems().add(realEstateModel);
        }

    }
    public void updateEstate(){

        String comboVal=comboCriterion.getValue().toString();
        idVal=Integer.parseInt(idEstate.getText());

        estate=estateService.getById(idVal);
        if(estate==null){
            ShowWarning.showInformation("No such user");
        }else {
            String upd = newVal.getText();

            if (comboVal.equals("Owner")) {
                estateService.changeEstateOwner(estate,upd);
            }
            if (comboVal.equals("Type")) {
                String updCombo = comboNewValue.getValue().toString();
                EstateType type=typeService.getTypeByName(updCombo);
                estateService.changeEstateType(estate,type);
            }
            if (comboVal.equals ("Area")) {
                estateService.changeEstateArea(estate,Double.parseDouble(upd));
            }
            if (comboVal.equals("Price")) {
                estateService.changeEstatePrice(estate,Double.parseDouble(upd));
            }
            if (comboVal.equals("Currency")) {
                String updCombo = comboNewValue.getValue().toString();
                EstateCurrency currency=currencyService.getCurrencyByName(updCombo);
                estateService.changeEstateCurrency(estate,currency);
            }
            if (comboVal.equals("City")) {
                String updCombo = comboNewValue.getValue().toString();
                EstateCity city=cityService.getCityByName(updCombo);
                estateService.changeEstateCity(estate,city);

            }
            if (comboVal.equals("Address")) {
                estateService.changeEstateAddress(estate,upd);
            }


            if (comboVal.equals("Floors")) {
                estateService.changeEstateFloors(estate,Integer.parseInt(upd));
            }
            if (comboVal.equals("Rooms")) {
                estateService.changeEstateRooms(estate,Integer.parseInt(upd));

            }
            if (comboVal.equals("Description")) {
                estateService.changeEstateDescription(estate,upd);

            }

            if (comboVal.equals("Status")) {
                estateService.changeEstateStatus(estate,Byte.parseByte(upd));
            }






            ShowWarning.showInformation("Successfull updating");
            clearFields();
        }
    }

    public void deleteEstate(){
        idVal=Integer.parseInt(idEstate.getText());
        estate=estateService.getById(idVal);
        if(estate==null){
            ShowWarning.showInformation("No such estate");
        }
        else {
            estateService.deleteRealEstate(estate);
            ShowWarning.showInformation("Successfull deleting");
            clearFields();
        }
    }
    private void clearFields(){
        idEstate.clear();
        newVal.clear();
        estatesTable.getItems().clear();
    }
}
