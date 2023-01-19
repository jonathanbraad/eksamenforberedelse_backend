package facades;

import entities.House;
import entities.Rental;
import entities.Tenant;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class testMain {


    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        TenantFacade tenantfacade = TenantFacade.getTenantFacade(emf);

        // tests for TenantFacade
        List<Tenant> tenantList = tenantfacade.getTenants();
        for (Tenant tenant : tenantList)
        {
            System.out.println(tenant.toString());
        }

        List<Rental> rentalList = tenantfacade.getRentalFromTenant(1);
        for (Rental rental : rentalList)
         {
            System.out.println(rental.toString());
         }

        House house = tenantfacade.getHouseFromRental(2);
        System.out.println(house.toString());


      //  tenantfacade.deleteRental(3);

    //    List<Tenant> tenantList2 = tenantfacade.getTenantsFromHouse(1);
      //  for (Tenant tenant : tenantList2)
       // {
         //   System.out.println(tenant.toString());
        // }
House house2 = new House(4, "blankavej 25", "cph", "asd");
//tenantfacade.createRental(4, "123", "321", "10000", "1000", "jens", house2);

       tenantfacade.CreateHouse(4, "by123", "cph", "asd");

       // tenantfacade.CreateTenant(4, "mads", "13231342", "kiosk");

    }


}
