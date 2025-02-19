package com.example.ducks_service.model;

public enum Type {
    MALLARD, REDHEAD, RUBBER_DUCK, DECOY_DUCK;

    public String toString(){
        return switch (this) {
            case MALLARD -> "MALLARD";
            case REDHEAD -> "REDHEAD";
            case RUBBER_DUCK -> "RUBBER_DUCK";
            case DECOY_DUCK -> "DECOY_DUCK";
        };
    }
}
