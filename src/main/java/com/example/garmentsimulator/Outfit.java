package com.example.garmentsimulator;

// This class uses a factory to create a complete matching outfit.
public class Outfit {
    private final Top top;
    private final Pants pants;
    private final Shoes shoes;

    public Outfit(GarmentFactory factory) {
        this.top = factory.createTop();
        this.pants = factory.createPants();
        this.shoes = factory.createShoes();
    }

    public String getOutfitDetails() {
        return "Top: " + top.getDescription() + "\n"
                + "Pants: " + pants.getDescription() + "\n"
                + "Shoes: " + shoes.getDescription();
    }
}
