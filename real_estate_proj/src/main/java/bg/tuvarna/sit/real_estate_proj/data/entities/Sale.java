package bg.tuvarna.sit.real_estate_proj.data.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sale")
    private int idSale;
    @Basic
    @Column(name = "sale_contract")
    private String contract;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "real_estate_id", referencedColumnName = "id_estate")
    private RealEstate estate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id_customer")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id_user")
    private Broker broker;

    public Sale(){};
    public Sale(String contract, RealEstate estate, Customer customer, Broker broker) {
        this.contract = contract;
        this.estate = estate;
        this.customer = customer;
        this.broker = broker;
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String name) {
        this.contract = name;
    }

    public RealEstate getEstate() {
        return estate;
    }

    public void setEstate(RealEstate estate) {
        this.estate = estate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Broker getBroker() {
        return broker;
    }

    public void setBroker(Broker broker) {
        this.broker = broker;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Sale other = (Sale)o;
        return Objects.equals(idSale, other.getIdSale());
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSale, contract, estate, customer, broker);
    }
}
