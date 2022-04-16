package bg.tuvarna.sit.real_estate_proj.presentation.controllers;

import bg.tuvarna.sit.real_estate_proj.data.entities.*;
import bg.tuvarna.sit.real_estate_proj.presentation.FormActions.ShowWarning;
import bg.tuvarna.sit.real_estate_proj.service.EstateCityService;
import bg.tuvarna.sit.real_estate_proj.service.EstateCurrencyService;
import bg.tuvarna.sit.real_estate_proj.service.EstateTypeService;
import bg.tuvarna.sit.real_estate_proj.service.RealEstateService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;

public class AddEstateController {
    @FXML
    private TextField owner;
    @FXML
    private ComboBox type;
    @FXML
    private TextField area;
    @FXML
    private TextField price;
    @FXML
    private ComboBox currency;
    @FXML
    private ComboBox city;
    @FXML
    private TextField address;
    @FXML
    private TextField floors;
    @FXML
    private TextField rooms;
    @FXML
    private TextArea description;

    private EstateTypeService estateTypeService=EstateTypeService.getInstance();
    private EstateCurrencyService estateCurrencyService=EstateCurrencyService.getInstance();
    private EstateCityService estateCityService=EstateCityService.getInstance();
    private RealEstateService estateService=RealEstateService.getInstance();
    private Administrator admin=(Administrator) HelloController.user;

    public void loadCombos(){
        List<EstateCity> citiesList=estateCityService.getAllCities();
        for(EstateCity cityVal:citiesList){
            city.getItems().add(cityVal.getCity().toString());
        }
        List<EstateCurrency> currencyList=estateCurrencyService.getAllCurrency();
        for(EstateCurrency currencyVal:currencyList){
            currency.getItems().add(currencyVal.getCurrency().toString());
        }
        List<EstateType> typeList=estateTypeService.getAllTypes();
        for(EstateType typeVal:typeList){
            type.getItems().add(typeVal.getType().toString());
        }


    }


    public void addEstate(){
        String ownerValue= owner.getText();
        EstateType typeValue=estateTypeService.getTypeByName(type.getValue().toString());
        Double areaValue= Double.parseDouble(area.getText());
        Double priceValue= Double.parseDouble(price.getText());
        EstateCurrency currencyValue=estateCurrencyService.getCurrencyByName(currency.getValue().toString());
        EstateCity cityValue=estateCityService.getCityByName(city.getValue().toString());
        String addressValue= address.getText();
        Integer floorsValue= Integer.parseInt(floors.getText());
        Integer roomsValue= Integer.parseInt(rooms.getText());
        String descriptionValue= description.getText();
        Byte statusValue=1;
         if(ownerValue.equals("")|| addressValue.equals("")||descriptionValue.equals("")){
            ShowWarning.showWarning("Empty field(s)");
        }
         else {
             RealEstate estateToAdd = new RealEstate(ownerValue, typeValue, areaValue, priceValue, currencyValue, cityValue, addressValue, floorsValue, roomsValue, descriptionValue, statusValue, admin);
             estateService.createRealEstate(estateToAdd);
             clearFields();
         }
    }

    private void clearFields(){
        owner.clear();
        area.clear();
        price.clear();
       address.clear();
        floors.clear();
        rooms.clear();
        description.clear();
    }

}
