package com.adeo.qualida.studio.common.navigation.model;

import lombok.Data;

import java.util.List;

@Data
public class ApplicationModule {
    private String name;
    private String key;
    private String icon;
    private String route;
    private String controller;
    private boolean enabled;
    private boolean secured;
    private String auth;
    private List<ModuleEndPoint> endpoints;
}
