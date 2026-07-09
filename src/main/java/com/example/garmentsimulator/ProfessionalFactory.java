package com.example.garmentsimulator;

// Concrete factory for the Professional garment family.
public class ProfessionalFactory implements GarmentFactory {
    @Override
    public Top createTop() {
        return new ProfessionalTop();
    }

    @Override
    public Pants createPants() {
        return new ProfessionalPants();
    }

    @Override
    public Shoes createShoes() {
        return new ProfessionalShoes();
    }
}
