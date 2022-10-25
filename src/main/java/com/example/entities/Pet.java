package com.example.entities;

import com.example.entities.auxiliaries.Category;
import com.example.entities.auxiliaries.Tag;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;


@Data
@Accessors(chain=true)
public class Pet {
    private Long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;
}
