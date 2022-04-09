package bg.tuvarna.sit.real_estate_proj.data.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("broker")
public class Broker extends User {
    @OneToMany(mappedBy = "broker",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Sale> sales=new HashSet<>();
    public Broker(){}

    public Broker(String username, String password, String firstname, String lastname,
                         String phone, String email) {
        super(username, password, firstname, lastname, phone, email);
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
