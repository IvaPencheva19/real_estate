package bg.tuvarna.sit.real_estate_proj.presentation.models;

public class EstateCurrencyModel {
    private String currency;

    public EstateCurrencyModel(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return  String.format("%s",currency);
    }
}
