package bg.tuvarna.sit.real_estate_proj.data.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "estate_type")
public class EstateType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type")
    private int idType;

    @Basic
    @Column(name = "type")
    private String type;



    public EstateType(){}

    public EstateType( String type) {
        this.type = type;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
       EstateType other = (EstateType)o;
        return Objects.equals(idType, other.getIdType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(idType, type);
    }
}
