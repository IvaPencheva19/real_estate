package bg.tuvarna.sit.real_estate_proj.presentation.models;

public class EstateCityModel {
    private String city;

    public EstateCityModel(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return  String.format("%s",city);
    }
}
