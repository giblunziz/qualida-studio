package com.adeo.qualida.studio.admin.project.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Project {
    private String id = UUID.randomUUID().toString(); // unmodifiable id
    private String name; // modifiable name
    private String owner; // refer to BU
    private String description;
    private ProjectType projectType;
    private boolean enabled;
}
