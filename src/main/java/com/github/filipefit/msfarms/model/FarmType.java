package com.github.filipefit.msfarms.model;

public enum FarmType {
    CONFINEMENT("Confinement"),
    OPEN_GRASS("Open grass");

    private String description;

    FarmType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
