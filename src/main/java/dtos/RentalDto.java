package dtos;

import entities.House;
import entities.Rental;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Rental} entity
 */
public class RentalDto implements Serializable {
    private final Integer id;
    @Size(max = 45)
    @NotNull
    private final String startDate;
    @Size(max = 45)
    @NotNull
    private final String endDate;
    @Size(max = 45)
    @NotNull
    private final String priceAnnual;
    @Size(max = 45)
    @NotNull
    private final String deposit;
    @Size(max = 45)
    @NotNull
    private final String contactPerson;
    @NotNull
    private final House house;

    public RentalDto(Integer id, String startDate, String endDate, String priceAnnual, String deposit, String contactPerson, House house) {
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

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getPriceAnnual() {
        return priceAnnual;
    }

    public String getDeposit() {
        return deposit;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public House getHouse() {
        return house;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalDto entity = (RentalDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.startDate, entity.startDate) &&
                Objects.equals(this.endDate, entity.endDate) &&
                Objects.equals(this.priceAnnual, entity.priceAnnual) &&
                Objects.equals(this.deposit, entity.deposit) &&
                Objects.equals(this.contactPerson, entity.contactPerson) &&
                Objects.equals(this.house, entity.house);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, priceAnnual, deposit, contactPerson, house);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "startDate = " + startDate + ", " +
                "endDate = " + endDate + ", " +
                "priceAnnual = " + priceAnnual + ", " +
                "deposit = " + deposit + ", " +
                "contactPerson = " + contactPerson + ", " +
                "house = " + house + ")";
    }
}