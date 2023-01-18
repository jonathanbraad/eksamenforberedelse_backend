package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RentaltenantId implements Serializable {
    private static final long serialVersionUID = -2461750742832040231L;
    @NotNull
    @Column(name = "rental_id", nullable = false)
    private Integer rentalId;

    @NotNull
    @Column(name = "tenant_id", nullable = false)
    private Integer tenantId;

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentaltenantId entity = (RentaltenantId) o;
        return Objects.equals(this.tenantId, entity.tenantId) &&
                Objects.equals(this.rentalId, entity.rentalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenantId, rentalId);
    }

}