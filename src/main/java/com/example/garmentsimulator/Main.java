package com.example.garmentsimulator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Driver class for testing the Abstract Factory Pattern using JavaFX.
public class Main extends Application {

    private final Label resultLabel = new Label("Choose an outfit style.");

    @Override
    public void start(Stage stage) {
        Label titleLabel = new Label("Garment Simulator");
        titleLabel.setStyle("-fx-font-size: 26px; -fx-font-weight: bold;");

        Label subtitleLabel = new Label("Abstract Factory Design Pattern");
        subtitleLabel.setStyle("-fx-font-size: 15px;");

        Button professionalButton = new Button("Professional Outfit");
        Button casualButton = new Button("Casual Outfit");
        Button partyButton = new Button("Party Outfit");

        professionalButton.setOnAction(e -> displayOutfit(new ProfessionalFactory(), "Professional"));
        casualButton.setOnAction(e -> displayOutfit(new CasualFactory(), "Casual"));
        partyButton.setOnAction(e -> displayOutfit(new PartyFactory(), "Party"));

        HBox buttonBox = new HBox(15, professionalButton, casualButton, partyButton);
        buttonBox.setAlignment(Pos.CENTER);

        resultLabel.setStyle("-fx-font-size: 16px; -fx-border-color: gray; -fx-padding: 15px; -fx-background-color: #f7f7f7;");
        resultLabel.setMinWidth(360);
        resultLabel.setAlignment(Pos.CENTER);

        VBox root = new VBox(20, titleLabel, subtitleLabel, buttonBox, resultLabel);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(25));

        Scene scene = new Scene(root, 560, 350);
        stage.setTitle("Garment Simulator");
        stage.setScene(scene);
        stage.show();
    }

    // Creates and displays a complete matching outfit using the selected factory.
    private void displayOutfit(GarmentFactory factory, String styleName) {
        Outfit outfit = new Outfit(factory);
        resultLabel.setText(styleName + " Outfit Selected\n\n" + outfit.getOutfitDetails());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
