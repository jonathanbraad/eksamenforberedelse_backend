package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "rental")
public class Rental {
    @Id
    @Column(name = "rental_id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "startDate", nullable = false, length = 45)
    private String startDate;

    @Size(max = 45)
    @NotNull
    @Column(name = "endDate", nullable = false, length = 45)
    private String endDate;

    @Size(max = 45)
    @NotNull
    @Column(name = "priceAnnual", nullable = false, length = 45)
    private String priceAnnual;

    @Size(max = 45)
    @NotNull
    @Column(name = "deposit", nullable = false, length = 45)
    private String deposit;

    @Size(max = 45)
    @NotNull
    @Column(name = "contactPerson", nullable = false, length = 45)
    private String contactPerson;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "house_id", nullable = false)
    private House house;

    public Rental() {
    }

    public Rental(Integer id, String startDate, String endDate, String priceAnnual, String deposit, String contactPerson, House house) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceAnnual = priceAnnual;
        this.deposit = deposit;
        this.contactPerson = contactPerson;
        this.house = house;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPriceAnnual() {
        return priceAnnual;
    }

    public void setPriceAnnual(String priceAnnual) {
        this.priceAnnual = priceAnnual;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", priceAnnual='" + priceAnnual + '\'' +
                ", deposit='" + deposit + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", house=" + house +
                '}';
    }
}