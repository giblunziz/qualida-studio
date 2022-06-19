package com.adeo.qualida.studio.common.navigation.model;

import lombok.Data;

@Data
public class ModuleEndPoint {
    private String name;
    private String key;
    private String endpoint;
    private boolean enabled;
}
