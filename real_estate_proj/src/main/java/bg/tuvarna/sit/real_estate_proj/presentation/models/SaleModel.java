package bg.tuvarna.sit.real_estate_proj.presentation.models;

import bg.tuvarna.sit.real_estate_proj.data.entities.Sale;

public class SaleModel {
    private Integer idSale;
    private String customerName;
    private String customerPhone;
    private String customerAddress;
    private Integer estateId;
    private String contractNumber;
    public SaleModel(Sale sale){
        idSale=sale.getIdSale();
        customerName=sale.getCustomer().getName();
        customerPhone=sale.getCustomer().getPhone();
        customerAddress=sale.getCustomer().getAddress();
        estateId=sale.getEstate().getIdEstate();
        contractNumber=sale.getContract();
    }

    public Integer getIdSale() {
        return idSale;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public String getContractNumber() {
        return contractNumber;
    }
}
