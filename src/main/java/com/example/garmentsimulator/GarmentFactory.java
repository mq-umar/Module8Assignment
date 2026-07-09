package com.example.garmentsimulator;

// Abstract Factory interface.
// Each concrete factory creates a matching family of garments.
public interface GarmentFactory {
    Top createTop();
    Pants createPants();
    Shoes createShoes();
}
