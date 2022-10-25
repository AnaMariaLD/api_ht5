package com.example.steps;

import com.example.entities.Pet;
import com.example.service.PetService;

import java.util.List;
import java.util.Map;

import static com.example.service.uritemplate.PetServiceUri.*;

public class PetServiceSteps {
    public static final PetService PET_SERVICE = PetService.getInstance();

    public static Pet createPet(Pet pet) {
        return PET_SERVICE.postRequest(PET, pet).as(Pet.class);
    }

    public static List<Pet> getPetByStatus(String status) {
        return PET_SERVICE.getRequestQuery(PET_BY_STATUS, status).jsonPath().getList("", Pet.class);
    }

    public static Map<String, Integer> getStoreInventory() {
        return PET_SERVICE.getRequest(STORE_INVENTORY).jsonPath().getMap("");
    }

    public static Pet updatePet(Pet createdPet) {
        return PET_SERVICE.putRequest(PET, createdPet).as(Pet.class);
    }


}
