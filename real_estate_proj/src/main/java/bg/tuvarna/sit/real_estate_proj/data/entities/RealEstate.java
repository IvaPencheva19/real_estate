package bg.tuvarna.sit.real_estate_proj.data.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "real_estate")
public class RealEstate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estate")
    private int idEstate;
    @Basic
    @Column(name = "estate_owner")
    private String estateOwner;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estate_type", nullable = false)
    private EstateType estateType;

    @Basic
    @Column(name = "estate_area")
    private Double estateArea;

    @Basic
    @Column(name = "estate_price")
    private Double estatePrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estate_currency", nullable = false)
    private EstateCurrency estateCurrency;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estate_city", nullable = false)
    private EstateCity estateCity;

    @Basic
    @Column(name = "estate_address")
    private String estateAddress;

    @Basic
    @Column(name = "estate_floors")
    private Integer estateFloors;

    @Basic
    @Column(name = "estate_rooms")
    private Integer estateRooms;

    @Basic
    @Column(name = "estate_description")
    private String estateDescription;
    @Basic
    @Column(name = "estate_status")
    private Byte estateStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private Administrator admin;

    @OneToMany(mappedBy = "estate",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Sale> sales=new HashSet<>();

    public RealEstate(){}
    public RealEstate(String estateOwner, EstateType estateType, Double estateArea, Double estatePrice, EstateCurrency estateCurrency, EstateCity estateCity, String estateAddress, Integer estateFloors,Integer estateRooms, String estateDescription, Byte estateStatus,Administrator admin) {
        this.estateOwner = estateOwner;
        this.estateType = estateType;
        this.estateArea = estateArea;
        this.estatePrice = estatePrice;
        this.estateCurrency = estateCurrency;
        this.estateCity = estateCity;
        this.estateAddress = estateAddress;
        this.estateFloors = estateFloors;
        this.estateRooms = estateRooms;
        this.estateDescription = estateDescription;
        this.estateStatus = estateStatus;
        this.admin = admin;
    }

    public int getIdEstate() {
        return idEstate;
    }

    public void setIdEstate(int idEstate) {
        this.idEstate = idEstate;
    }

    public String getEstateOwner() {
        return estateOwner;
    }

    public void setEstateOwner(String estateOwner) {
        this.estateOwner = estateOwner;
    }

    public EstateType getEstateType() {
        return estateType;
    }

    public void setEstateType(EstateType estateType) {
        this.estateType = estateType;
    }

    public Double getEstateArea() {
        return estateArea;
    }

    public void setEstateArea(Double estateArea) {
        this.estateArea = estateArea;
    }

    public Double getEstatePrice() {
        return estatePrice;
    }

    public void setEstatePrice(Double estatePrice) {
        this.estatePrice = estatePrice;
    }

    public EstateCurrency getEstateCurrency() {
        return estateCurrency;
    }

    public void setEstateCurrency(EstateCurrency estateCurrency) {
        this.estateCurrency = estateCurrency;
    }

    public EstateCity getEstateCity() {
        return estateCity;
    }

    public void setEstateCity(EstateCity estateCity) {
        this.estateCity = estateCity;
    }

    public String getEstateAddress() {
        return estateAddress;
    }

    public void setEstateAddress(String estateAddress) {
        this.estateAddress = estateAddress;
    }

    public Integer getEstateFloors() {
        return estateFloors;
    }

    public void setEstateFloors(Integer estateFloors) {
        this.estateFloors = estateFloors;
    }

    public String getEstateDescription() {
        return estateDescription;
    }

    public void setEstateDescription(String estateDescription) {
        this.estateDescription = estateDescription;
    }

    public Byte getEstateStatus() {
        return estateStatus;
    }

    public void setEstateStatus(Byte estateStatus) {
        this.estateStatus = estateStatus;
    }

    public Administrator getAdmin() {
        return admin;
    }

    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    public Integer getEstateRooms() {
        return estateRooms;
    }

    public void setEstateRooms(Integer estateRooms) {
        this.estateRooms = estateRooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        RealEstate other = (RealEstate)o;
        return Objects.equals(idEstate, other.getIdEstate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstate, estateOwner, estateType, estateArea, estatePrice, estateCurrency, estateCity, estateAddress, estateFloors, estateDescription, estateStatus, admin,sales);
    }
}
