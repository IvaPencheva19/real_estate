package bg.tuvarna.sit.real_estate_proj.data.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private int idCustomer;
    @Basic
    @Column(name = "customer_name")
    private String name;
    @Basic
    @Column(name = "customer_phone")
    private String phone;
    @Basic
    @Column(name = "customer_address")
    private String address;


    public Customer(){}
    public Customer(String name, String phone, String address) {

        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idUser) {
        this.idCustomer = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Customer other = (Customer)o;
        return Objects.equals(idCustomer, other.getIdCustomer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCustomer, name, phone, address);
    }
}
