package bg.tuvarna.sit.real_estate_proj.presentation.models;


import bg.tuvarna.sit.real_estate_proj.data.entities.Administrator;

public class AdminModel {

    private String username;

    private String firstname;
    private String lastname;
    private String phone;
    private String email;

    public AdminModel(Administrator admin){
        username=admin.getUsername();
        firstname=admin.getFirstname();
        lastname=admin.getLastname();
        email=admin.getEmail();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


