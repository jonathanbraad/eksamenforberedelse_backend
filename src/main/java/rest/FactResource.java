package rest;

import com.google.gson.Gson;
import dtos.CatfactDTO;
import dtos.CombinedFactsDTO;
import dtos.DogfactDTO;
import utils.HttpUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;

@Path("facts")
public class FactResource {
    @Context
    private UriInfo context;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getFacts() throws IOException {
        Gson gson = new Gson();
        DogfactDTO dogfactDTO = new DogfactDTO();
        String dog = HttpUtils.fetchData(dogfactDTO.getUrl());
        DogfactDTO dogDTO = gson.fromJson(dog, DogfactDTO.class);

        CatfactDTO catfactDTO = new CatfactDTO();
        String cat = HttpUtils.fetchData(catfactDTO.getUrl());
        CatfactDTO catDTO = gson.fromJson(cat, CatfactDTO.class);

        CombinedFactsDTO combinedFactsDTO = new CombinedFactsDTO(catDTO, dogDTO);

        return gson.toJson(combinedFactsDTO);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("dog")
    public String getDogFacts() throws IOException {
        Gson gson = new Gson();
        DogfactDTO dogfactDTO = new DogfactDTO();
        String dog = HttpUtils.fetchData(dogfactDTO.getUrl());
        DogfactDTO dogDTO = gson.fromJson(dog, DogfactDTO.class);

        return gson.toJson(dogDTO);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("cat")
    public String getCatFacts() throws IOException {
        Gson gson = new Gson();
        CatfactDTO catfactDTO = new CatfactDTO();
        String cat = HttpUtils.fetchData(catfactDTO.getUrl());
        CatfactDTO catDTO = gson.fromJson(cat, CatfactDTO.class);

        return gson.toJson(catDTO);
    }


}
