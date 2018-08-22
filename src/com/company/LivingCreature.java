package com.company;

import java.util.UUID;

public class LivingCreature {
    protected String id;
    protected String name;

    public LivingCreature(String name) {
        id = UUID.randomUUID().toString();
        this.name = name;
    }


}
