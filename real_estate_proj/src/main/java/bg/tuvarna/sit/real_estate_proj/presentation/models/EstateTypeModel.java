package bg.tuvarna.sit.real_estate_proj.presentation.models;

public class EstateTypeModel {
    private String type;

    public EstateTypeModel(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return  String.format("%s",type);
    }


}
