# Garment Simulator JavaFX - Abstract Factory Pattern

This project models a garment simulator using the Abstract Factory design pattern.

The program creates matching outfits from three garment families:

- Professional
- Casual
- Party

Each family contains a matching Top, Pants, and Shoes object.

## Design Pattern Used

The correct design pattern is the Abstract Factory Pattern because the program needs to create families of related objects without mixing styles.

For example, when the Professional factory is selected, it creates:

- Professional Top
- Professional Pants
- Professional Shoes

This keeps the outfit consistent and makes the program easier to expand later.

## How to Run

Open the project in IntelliJ or Eclipse as a Maven project.

Then run:

```bash
mvn javafx:run
```

Or run the `Main.java` file from your IDE.
