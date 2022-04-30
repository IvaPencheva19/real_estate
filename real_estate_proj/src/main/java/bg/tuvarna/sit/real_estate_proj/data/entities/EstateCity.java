package bg.tuvarna.sit.real_estate_proj.data.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "estate_city")
public class EstateCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_city")
    private int idCity;

    @Basic
    @Column(name = "city")
    private String city;




    public EstateCity() {
    }

    public EstateCity(String city) {
        this.city = city;
    }


    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        EstateCity other = (EstateCity)o;
        return Objects.equals(idCity, other.getIdCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCity, city);
    }
}
