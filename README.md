# Module 8 Assignment - Garment Simulator

This JavaFX project models a garment simulator using the **Abstract Factory Design Pattern**.

The simulator creates matching outfits from the same family/variant:

- Professional
- Casual
- Party

Each outfit contains:

- Top
- Pants
- Shoes

The JavaFX screen has three buttons. When the user clicks a button, the program uses the correct factory to create and display a matching outfit.

## Design Pattern Used

The selected design pattern is the **Abstract Factory Pattern** because the assignment requires creating families of related objects without changing the main code every time a new family is added.

## How to Run

Open the project in IntelliJ IDEA or another Java IDE that supports Maven, then run:

```bash
mvn clean javafx:run
```

## Main Files

- `Main.java` - JavaFX application and driver class
- `GarmentFactory` - abstract factory interface
- `ProfessionalFactory`, `CasualFactory`, `PartyFactory` - concrete factories
- `Top`, `Pants`, `Shoes` - product interfaces
- Concrete product classes for each outfit family
