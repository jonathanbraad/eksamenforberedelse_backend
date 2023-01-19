package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.HouseDto;
import dtos.MealDTO;
import dtos.MealPlanDTO;
import entities.House;
import entities.Tenant;
import entities.User;
import facades.MealFacade;
import facades.MealPlanFacade;
import facades.TenantFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("tenant")
public class TenantResource {

    @Context
    private UriInfo context;

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final TenantFacade tenantFacade = TenantFacade.getTenantFacade(EMF);
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Path("getall")
    @GET
    @Produces("text/plain")
    public String getTenants() {
        EntityManager em = EMF.createEntityManager();
        try {
            TypedQuery<Tenant> query = em.createQuery("select t from Tenant t", entities.Tenant.class);
            List<Tenant> tenants = query.getResultList();
            return "[" + tenants.size() + "]";
        } finally {
            em.close();
        }
    }

    @Path("viewRental/{tenant_id}")
    @GET
    @Produces("text/plain")
    public String getRentalFromTenant(@PathParam("tenant_id") int tenantId) {
        return gson.toJson(tenantFacade.getRentalFromTenant(tenantId));
    }

    @Path("viewHouseFromRental/{rental_id}")
    @GET
    @Produces("text/plain")
    public String viewHouseFromRental(@PathParam("rental_id") int rentalId) {
        return gson.toJson(tenantFacade.getHouseFromRental(rentalId));
    }

    @DELETE
    @Path("deleteRental/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public void deleteMealPlan(@PathParam("id") int id) {
        tenantFacade.deleteRental(id);
    }

    @POST
    @Path("createHouse/{house_id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createHouse(@PathParam("house_id") Integer id, String jsonInput){
        HouseDto houseDTO = gson.fromJson(jsonInput, HouseDto.class);
        HouseDto returned = tenantFacade.createHousedto(houseDTO, id);
        return Response.ok().entity(gson.toJson(returned)).build();
    }
}


