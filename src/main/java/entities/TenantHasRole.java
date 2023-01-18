package entities;

import javax.persistence.*;

@Entity
@Table(name = "tenant_has_roles")
public class TenantHasRole {
    @EmbeddedId
    private TenantHasRoleId id;

    @MapsId("tenantId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    @MapsId("roleName")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_name", nullable = false)
    private Roles roleName;

    public TenantHasRoleId getId() {
        return id;
    }

    public void setId(TenantHasRoleId id) {
        this.id = id;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Roles getRoleName() {
        return roleName;
    }

    public void setRoleName(Roles roleName) {
        this.roleName = roleName;
    }

}