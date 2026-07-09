package com.example.module8assignment;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*
 * Module 8 Assignment
 * Garment Simulator using the Abstract Factory Design Pattern.
 *
 * The purpose of this program is to create matching garment objects.
 * Each factory creates a full outfit from the same family, such as
 * Professional, Casual, or Party.
 */
public class Main extends Application {

    private final Label resultLabel = new Label("Select an outfit type to create a matching set.");

    @Override
    public void start(Stage stage) {
        Label titleLabel = new Label("Garment Simulator");
        titleLabel.setFont(new Font("Arial", 26));

        Label subtitleLabel = new Label("Abstract Factory Design Pattern");
        subtitleLabel.setFont(new Font("Arial", 16));

        Button professionalButton = new Button("Professional Outfit");
        Button casualButton = new Button("Casual Outfit");
        Button partyButton = new Button("Party Outfit");

        professionalButton.setPrefWidth(220);
        casualButton.setPrefWidth(220);
        partyButton.setPrefWidth(220);

        // Each button uses a different concrete factory.
        professionalButton.setOnAction(e -> displayOutfit(new ProfessionalFactory()));
        casualButton.setOnAction(e -> displayOutfit(new CasualFactory()));
        partyButton.setOnAction(e -> displayOutfit(new PartyFactory()));

        resultLabel.setFont(new Font("Arial", 15));
        resultLabel.setWrapText(true);
        resultLabel.setMaxWidth(360);
        resultLabel.setAlignment(Pos.CENTER);

        VBox root = new VBox(15, titleLabel, subtitleLabel, professionalButton, casualButton, partyButton, resultLabel);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(25));

        Scene scene = new Scene(root, 500, 420);
        stage.setTitle("Module 8 Garment Simulator");
        stage.setScene(scene);
        stage.show();
    }

    /*
     * This method acts as the driver/test for the program.
     * It receives a factory, creates the matching products, and displays them.
     */
    private void displayOutfit(GarmentFactory factory) {
        Top top = factory.createTop();
        Pants pants = factory.createPants();
        Shoes shoes = factory.createShoes();

        Outfit outfit = new Outfit(top, pants, shoes);
        resultLabel.setText(outfit.getDescription());
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/*
 * Abstract Factory interface.
 * Every concrete factory must create a matching top, pants, and shoes.
 */
interface GarmentFactory {
    Top createTop();
    Pants createPants();
    Shoes createShoes();
}

/* Product interfaces. */
interface Top {
    String getDescription();
}

interface Pants {
    String getDescription();
}

interface Shoes {
    String getDescription();
}

/* Concrete factory for professional garments. */
class ProfessionalFactory implements GarmentFactory {
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

/* Concrete factory for casual garments. */
class CasualFactory implements GarmentFactory {
    @Override
    public Top createTop() {
        return new CasualTop();
    }

    @Override
    public Pants createPants() {
        return new CasualPants();
    }

    @Override
    public Shoes createShoes() {
        return new CasualShoes();
    }
}

/* Concrete factory for party garments. */
class PartyFactory implements GarmentFactory {
    @Override
    public Top createTop() {
        return new PartyTop();
    }

    @Override
    public Pants createPants() {
        return new PartyPants();
    }

    @Override
    public Shoes createShoes() {
        return new PartyShoes();
    }
}

/* Professional product classes. */
class ProfessionalTop implements Top {
    @Override
    public String getDescription() {
        return "Professional Top: dress shirt or blouse";
    }
}

class ProfessionalPants implements Pants {
    @Override
    public String getDescription() {
        return "Professional Pants: formal work pants";
    }
}

class ProfessionalShoes implements Shoes {
    @Override
    public String getDescription() {
        return "Professional Shoes: dress shoes";
    }
}

/* Casual product classes. */
class CasualTop implements Top {
    @Override
    public String getDescription() {
        return "Casual Top: comfortable everyday shirt";
    }
}

class CasualPants implements Pants {
    @Override
    public String getDescription() {
        return "Casual Pants: jeans or joggers";
    }
}

class CasualShoes implements Shoes {
    @Override
    public String getDescription() {
        return "Casual Shoes: sneakers";
    }
}

/* Party product classes. */
class PartyTop implements Top {
    @Override
    public String getDescription() {
        return "Party Top: stylish party shirt";
    }
}

class PartyPants implements Pants {
    @Override
    public String getDescription() {
        return "Party Pants: fashionable party pants";
    }
}

class PartyShoes implements Shoes {
    @Override
    public String getDescription() {
        return "Party Shoes: stylish boots or heels";
    }
}

/*
 * Outfit class combines the products created by the factory.
 * This keeps the top, pants, and shoes together as one matching set.
 */
class Outfit {
    private final Top top;
    private final Pants pants;
    private final Shoes shoes;

    public Outfit(Top top, Pants pants, Shoes shoes) {
        this.top = top;
        this.pants = pants;
        this.shoes = shoes;
    }

    public String getDescription() {
        return "Matching Outfit Created:\n\n"
                + top.getDescription() + "\n"
                + pants.getDescription() + "\n"
                + shoes.getDescription();
    }
}
