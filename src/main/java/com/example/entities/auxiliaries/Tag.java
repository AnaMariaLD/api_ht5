package com.example.entities.auxiliaries;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class Tag {
    private Long id;
    private String name;
}
