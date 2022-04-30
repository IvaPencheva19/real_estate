package bg.tuvarna.sit.real_estate_proj.data.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "estate_currency")
public class EstateCurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_currency")
    private int idCurrency;

    @Basic
    @Column(name = "currency")
    private String currency;



    public EstateCurrency(){}
    public EstateCurrency(String currency) {
        this.currency = currency;
    }

    public int getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(int idCurrency) {
        this.idCurrency = idCurrency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        EstateCurrency other = (EstateCurrency)o;
        return Objects.equals(idCurrency, other.getIdCurrency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCurrency, currency);
    }
}
