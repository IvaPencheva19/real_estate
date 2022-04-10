package bg.tuvarna.sit.real_estate_proj.presentation.models;

public class CustomerModel {
    private String cusName;
    private String cusPhone;
    private String cusAddress;

    public CustomerModel(String cusName, String cusPhone, String cusAddress) {
        this.cusName = cusName;
        this.cusPhone = cusPhone;
        this.cusAddress = cusAddress;
    }

    @Override
    public String toString() {
        return  String.format("%s %s %s",cusName, cusPhone,
                cusAddress);
    }
}
