package com.example.petstest;

import com.example.entities.Pet;
import com.example.entities.auxiliaries.Category;
import com.example.entities.auxiliaries.Tag;
import com.example.steps.PetServiceSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.*;

import static java.lang.Math.pow;

public class PetStoreTests {
    @Test
    public void createPetTest() {
        Pet expectedPet = createPet();
        Pet actualPet = PetServiceSteps.createPet(expectedPet);
        Assert.assertEquals(actualPet.getName(), expectedPet.getName(),
                "Expected pet name does not match created pet name");
    }

    @Test
    public void checkNumberOfAvailablePets() {
        List<Pet> pets = PetServiceSteps.getPetByStatus("available");
        Map<String, Integer> storeInventory = PetServiceSteps.getStoreInventory();
        Assert.assertEquals(pets.size(), storeInventory.get("available"),
                "Available pets number doesn't match inventory");
    }

    @Test
    public void updatePetStatusToSold() {
        Pet createdPet = PetServiceSteps.createPet(createPet());
        createdPet.setStatus("sold");
        Pet actualPet = PetServiceSteps.updatePet(createdPet);
        Assert.assertEquals(createdPet.getStatus(), actualPet.getStatus(),
                "Status was not updated to sold");
    }

    private Pet createPet() {
        Random random = new Random();
        Long id = random.nextLong(0L, (long) pow(10, 20));
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        List<Tag> tags = new ArrayList<>();
        Tag tag = new Tag().setId(id).setName("something" + timestamp);
        tags.add(tag);
        Category category = new Category().setId(id).setName("dog" + timestamp);
        return new Pet()
                .setId(id)
                .setCategory(category)
                .setName("Bobby" + timestamp)
                .setPhotoUrls(Arrays.asList("sourceOfPhoto" + timestamp))
                .setTags(tags)
                .setStatus("available");
    }
}
