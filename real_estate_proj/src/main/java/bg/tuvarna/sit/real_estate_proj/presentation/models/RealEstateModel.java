package bg.tuvarna.sit.real_estate_proj.presentation.models;

import bg.tuvarna.sit.real_estate_proj.data.entities.RealEstate;


public class RealEstateModel {
    private int idEstate;
    private String estateOwner;
    private String estateType;
    private Double estateArea;
    private Double estatePrice;
    private String estateCurrency;
    private String estateCity;
    private String estateAddress;
    private Integer estateFloors;
    private Integer estateRooms;
    private String estateDescription;
    private Byte estateStatus;

    public RealEstateModel(RealEstate estate){
        idEstate=estate.getIdEstate();
        estateOwner=estate.getEstateOwner();
        estateType=estate.getEstateType().getType();
        estateArea=estate.getEstateArea();
        estatePrice=estate.getEstatePrice();
        estateCurrency=estate.getEstateCurrency().getCurrency();
        estateCity=estate.getEstateCity().getCity();
        estateAddress=estate.getEstateAddress();
        estateFloors=estate.getEstateFloors();
        estateRooms=estate.getEstateRooms();
        estateDescription=estate.getEstateDescription();
        estateStatus=estate.getEstateStatus();
    }

    public int getIdEstate() {
        return idEstate;
    }

    public void setIdEstate(int idEstate) {
        this.idEstate = idEstate;
    }

    public String getEstateOwner() {
        return estateOwner;
    }

    public void setEstateOwner(String estateOwner) {
        this.estateOwner = estateOwner;
    }

    public String getEstateType() {
        return estateType;
    }

    public void setEstateType(String estateType) {
        this.estateType = estateType;
    }

    public Double getEstateArea() {
        return estateArea;
    }

    public void setEstateArea(Double estateArea) {
        this.estateArea = estateArea;
    }

    public Double getEstatePrice() {
        return estatePrice;
    }

    public void setEstatePrice(Double estatePrice) {
        this.estatePrice = estatePrice;
    }

    public String getEstateCurrency() {
        return estateCurrency;
    }

    public void setEstateCurrency(String estateCurrency) {
        this.estateCurrency = estateCurrency;
    }

    public String getEstateCity() {
        return estateCity;
    }

    public void setEstateCity(String estateCity) {
        this.estateCity = estateCity;
    }

    public String getEstateAddress() {
        return estateAddress;
    }

    public void setEstateAddress(String estateAddress) {
        this.estateAddress = estateAddress;
    }

    public Integer getEstateFloors() {
        return estateFloors;
    }

    public void setEstateFloors(Integer estateFloors) {
        this.estateFloors = estateFloors;
    }

    public Integer getEstateRooms() {
        return estateRooms;
    }

    public void setEstateRooms(Integer estateRooms) {
        this.estateRooms = estateRooms;
    }

    public String getEstateDescription() {
        return estateDescription;
    }

    public void setEstateDescription(String estateDescription) {
        this.estateDescription = estateDescription;
    }

    public Byte getEstateStatus() {
        return estateStatus;
    }

    public void setEstateStatus(Byte estateStatus) {
        this.estateStatus = estateStatus;
    }
}
