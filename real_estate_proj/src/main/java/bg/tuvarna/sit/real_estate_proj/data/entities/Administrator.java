package bg.tuvarna.sit.real_estate_proj.data.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("admin")
public class Administrator extends User {
    @OneToMany(mappedBy = "admin",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<RealEstate> estates=new HashSet<>();

    public Set<RealEstate> getEstates() {
        return estates;
    }

    public void setEstates(Set<RealEstate> estates) {
        this.estates = estates;
    }

    public Administrator(){}

    public Administrator(String username, String password, String firstname, String lastname,
                 String phone, String email) {
        super(username, password, firstname, lastname, phone, email);
    }
}
