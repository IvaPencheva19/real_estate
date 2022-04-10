package bg.tuvarna.sit.real_estate_proj.presentation.models;

public class BrokerModel {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public BrokerModel(String username, String password, String firstName, String lastName, String phone, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return  String.format("%s %s %s %s %s $s",username, password,
                firstName, lastName, phone,email);
    }
}
