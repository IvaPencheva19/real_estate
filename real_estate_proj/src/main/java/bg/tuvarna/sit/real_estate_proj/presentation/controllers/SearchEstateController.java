package bg.tuvarna.sit.real_estate_proj.presentation.controllers;

import bg.tuvarna.sit.real_estate_proj.data.entities.EstateCity;
import bg.tuvarna.sit.real_estate_proj.data.entities.EstateCurrency;
import bg.tuvarna.sit.real_estate_proj.data.entities.EstateType;
import bg.tuvarna.sit.real_estate_proj.data.entities.RealEstate;
import bg.tuvarna.sit.real_estate_proj.presentation.FormActions.ShowWarning;
import bg.tuvarna.sit.real_estate_proj.presentation.models.RealEstateModel;
import bg.tuvarna.sit.real_estate_proj.service.EstateCityService;
import bg.tuvarna.sit.real_estate_proj.service.EstateCurrencyService;
import bg.tuvarna.sit.real_estate_proj.service.EstateTypeService;
import bg.tuvarna.sit.real_estate_proj.service.RealEstateService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class SearchEstateController {
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
    private RealEstateService estateService=RealEstateService.getInstance();
    private EstateTypeService typeService=EstateTypeService.getInstance();
    private EstateCityService cityService=EstateCityService.getInstance();
    private EstateCurrencyService currencyService=EstateCurrencyService.getInstance();
    private RealEstateModel realEstateModel;

    @FXML
    private TextField toSearch;
    public void loadCombo() {
        comboCriterion.getItems().add("Owner");
        comboCriterion.getItems().add("Type");
        comboCriterion.getItems().add("Area");
        comboCriterion.getItems().add("Price");
        comboCriterion.getItems().add("Currency");
        comboCriterion.getItems().add("City");
        comboCriterion.getItems().add("Address");
        comboCriterion.getItems().add("Floors");
        comboCriterion.getItems().add("Rooms");
        comboCriterion.getItems().add("Status");
        comboNewValue.setVisible(false);
        comboCriterion.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                if(comboCriterion.getValue()=="Type"){
                    comboNewValue.setVisible(true);
                    toSearch.setVisible(false);

                    List<EstateType> typeList=typeService.getAllTypes();
                    comboNewValue.getItems().clear();
                    for(EstateType typeVal:typeList){
                        comboNewValue.getItems().add(typeVal.getType());
                    }

                }
                else if(comboCriterion.getValue()=="Currency"){
                    comboNewValue.setVisible(true);
                    toSearch.setVisible(false);
                    List<EstateCurrency> currencyList=currencyService.getAllCurrency();
                    comboNewValue.getItems().clear();
                    for(EstateCurrency currencyVal:currencyList){
                        comboNewValue.getItems().add(currencyVal.getCurrency());
                    }
                }
                else if(comboCriterion.getValue()=="City"){
                    comboNewValue.setVisible(true);
                    toSearch.setVisible(false);
                    List<EstateCity> citiesList=cityService.getAllCities();
                    comboNewValue.getItems().clear();
                    for(EstateCity cityVal:citiesList){
                        comboNewValue.getItems().add(cityVal.getCity());
                    }
                }
                else{
                    comboNewValue.setVisible(false);
                    toSearch.setVisible(true);
                }
            }
        });
    }

    public void setPropertyTable(){
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
    }

    public void searchEstate(){
        clearFields();
        String comboVal=comboCriterion.getValue().toString();


        RealEstateModel estateModel;
            if (comboVal.equals("Owner")) {
                String upd=toSearch.getText();
            List<RealEstate> estates=estateService.getAllEstatesByOwner(upd);
                   for(RealEstate estate:estates) {
                       estateModel = new RealEstateModel(estate);
                       estatesTable.getItems().add(estateModel);
                   }

            }
            if (comboVal.equals("Type")) {
                String updCombo = comboNewValue.getValue().toString();
                EstateType type=typeService.getTypeByName(updCombo);
                List<RealEstate> estates=estateService.getAllEstatesByType(type);
                for(RealEstate estate:estates) {
                    estateModel = new RealEstateModel(estate);
                    estatesTable.getItems().add(estateModel);
                }

            }
            if (comboVal.equals ("Area")) {
                Double upd = Double.parseDouble(toSearch.getText());
                List<RealEstate> estates=estateService.getAllEstatesByArea(upd);
                for(RealEstate estate:estates) {
                    estateModel = new RealEstateModel(estate);
                    estatesTable.getItems().add(estateModel);
                }
            }
            if (comboVal.equals("Price")) {
                Double upd = Double.parseDouble(toSearch.getText());
                List<RealEstate> estates=estateService.getAllEstatesByPrice(upd);
                for(RealEstate estate:estates) {
                   estateModel = new RealEstateModel(estate);
                    estatesTable.getItems().add(estateModel);
                }
            }
            if (comboVal.equals("Currency")) {
                String updCombo = comboNewValue.getValue().toString();
                EstateCurrency currency=currencyService.getCurrencyByName(updCombo);
                List<RealEstate> estates=estateService.getAllEstatesByCurrency(currency);
                for(RealEstate estate:estates) {
                    estateModel = new RealEstateModel(estate);
                    estatesTable.getItems().add(estateModel);
                }

            }
            if (comboVal.equals("City")) {
                String updCombo = comboNewValue.getValue().toString();
                EstateCity city=cityService.getCityByName(updCombo);
                List<RealEstate> estates=estateService.getAllEstatesByCity(city);
                for(RealEstate estate:estates) {
                    estateModel = new RealEstateModel(estate);
                    estatesTable.getItems().add(estateModel);
                }


            }
            if (comboVal.equals("Address")) {
                String upd = toSearch.getText();
                List<RealEstate> estates=estateService.getAllEstatesByAddress(upd);
                for(RealEstate estate:estates) {
                    estateModel = new RealEstateModel(estate);
                    estatesTable.getItems().add(estateModel);
                }
            }


            if (comboVal.equals("Floors")) {
                Integer upd=Integer.parseInt(toSearch.getText());
                List<RealEstate> estates=estateService.getAllEstatesByFloors(upd);
                for(RealEstate estate:estates) {
                    estateModel = new RealEstateModel(estate);
                    estatesTable.getItems().add(estateModel);
                }

            }
            if (comboVal.equals("Rooms")) {
                Integer upd=Integer.parseInt(toSearch.getText());
                List<RealEstate> estates=estateService.getAllEstatesByRooms(upd);
                for(RealEstate estate:estates) {
                    estateModel = new RealEstateModel(estate);
                    estatesTable.getItems().add(estateModel);
                }

            }
            if (comboVal.equals("Description")) {
                String upd = toSearch.getText();

            }

            if (comboVal.equals("Status")) {
                Byte upd=Byte.parseByte(toSearch.getText());
                List<RealEstate> estates=estateService.getAllEstatesByStatus(upd);
                for(RealEstate estate:estates) {
                    estateModel = new RealEstateModel(estate);
                    estatesTable.getItems().add(estateModel);
                }
            }



    }
    private void clearFields(){
        estatesTable.getItems().clear();
    }
}
