package facades;

import dtos.MealPlanDTO;
import entities.*;
import security.errorhandling.AuthenticationException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class TenantFacade {
    private static EntityManagerFactory emf;
    private static TenantFacade instance;

    private TenantFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static TenantFacade getTenantFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new TenantFacade();
        }
        return instance;
    }

    public List<Tenant> getTenants()
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            TypedQuery<Tenant> query = em.createQuery("SELECT t FROM Tenant t", Tenant.class);
            return query.getResultList();
        }
        finally
        {
            em.close();
        }
    }

    public List<Rental> getRentalFromTenant(long TenantId) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Rental> query = em.createQuery("SELECT r FROM Rental r JOIN Rentaltenant ren JOIN ren.tenant t WHERE t.id = :id", Rental.class);
            query.setParameter("id", TenantId);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public House getHouseFromRental(int rentalId) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<House> query = em.createQuery("SELECT h FROM House h JOIN Rental r WHERE h.id = :id", House.class);
            query.setParameter("id", rentalId);
            return query.getSingleResult();
        } finally {
            em.close();
        }
    }

    public void deleteRental(Integer RentalId) {
        EntityManager em = emf.createEntityManager();

        Rental rental = em.find(Rental.class, RentalId);
        try {

            em.getTransaction().begin();
            em.remove(rental);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Tenant> getTenantsFromHouse(int houseId) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Tenant> query = em.createQuery("SELECT h FROM House h JOIN Rental r JOIN Rentaltenant rt JOIN Tenant t WHERE t.id = :id", Tenant.class);
            query.setParameter("id", houseId);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Rental createRental (int rental_id, String startDate, String endDate, String priceAnnual, String deposit, String contactPerson, House house)
    {
        EntityManager em = emf.createEntityManager();
        Rental newRental = new Rental(rental_id, startDate, endDate, priceAnnual, deposit, contactPerson, house);
        em.getTransaction().begin();
        em.persist(newRental);
        em.getTransaction().commit();
        em.close();
        return newRental;
    }


    public Tenant getVerifiedTenant(String name, String phone){
        EntityManager em = emf.createEntityManager();
        Tenant tenant;
        try {
            tenant = em.find(Tenant.class, name);
            if (tenant == null) {
                System.out.println("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return tenant;
    }
}
