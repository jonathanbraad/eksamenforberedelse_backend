package dtos;

import entities.House;
import entities.Meal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link entities.House} entity
 */
public class HouseDto implements Serializable {
    private final Integer id;
    @Size(max = 45)
    @NotNull
    private final String address;
    @Size(max = 45)
    @NotNull
    private final String city;
    @Size(max = 45)
    @NotNull
    private final String job;

    public HouseDto(Integer id, String address, String city, String job) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.job = job;
    }

    public HouseDto(House house) {
        this.id = house.getId();
        this.address = house.getAddress();
        this.city = house.getCity();
        this.job = house.getJob();
    }

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getJob() {
        return job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseDto entity = (HouseDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.city, entity.city) &&
                Objects.equals(this.job, entity.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, city, job);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "address = " + address + ", " +
                "city = " + city + ", " +
                "job = " + job + ")";
    }
}