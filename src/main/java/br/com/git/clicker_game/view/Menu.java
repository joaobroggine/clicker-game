package br.com.git.clicker_game.view;

import br.com.git.clicker_game.core.GameManager;
import br.com.git.clicker_game.model.Count;
import br.com.git.clicker_game.model.Inventory;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Menu {

    private final Inventory inventory;
    private final Count count;
    private Stage stage;

    public Menu(Inventory inventory, Count count) {
        this.inventory = inventory;
        this.count = count;
    }

    public void show() {

        stage = new Stage();
        stage.setTitle("Shop");
        stage.setResizable(false);

        // GameManager
        GameManager.setShopScreen(stage);

        // Label
        Label label = new Label("Shop");
        label.setStyle("-fx-font-size: 24px; -fx-text-fill: #333; -fx-font-weight: bold;");

        // Grid
        GridPane grid = new GridPane();
        grid.setHgap(50);
        grid.setVgap(10);

        // Buttons
        Button hatButton = new Button("Buy a Hat - $10");
        hatButton.setOnAction(e -> inventory.buyHat());

        Button guitarButton = new Button("Buy a Guitar - $150");
        guitarButton.setOnAction(e -> inventory.buyGuitar());

        Button betButton = new Button("Try your Luck");
        betButton.setVisible(false);
        betButton.setOnAction(e -> {
            Bet bet = new Bet(count);
            bet.show();
        });

        Button fasterButton = new Button("Faster Click - $5.000");
        fasterButton.setVisible(false);
        fasterButton.setOnAction(e -> {
            inventory.buyFasterClick();
            if (inventory.hasFasterClick()) {
                fasterButton.setVisible(false);
            }
        });

        Button churchButton = new Button("Build a Church - $50.000");
        churchButton.setVisible(false);
        churchButton.setOnAction(e -> {
            inventory.buyChurch();
        });

        Button ecommerceButton = new Button("E-commerce - $10.000");
        ecommerceButton.setVisible(false);
        ecommerceButton.setOnAction(e -> {
            inventory.buyEcommerce();
            if (inventory.hasEcommerce()) {
                churchButton.setVisible(true);
            }
        });

        Button pcButton = new Button("Buy a PC - $5.000");
        pcButton.setVisible(false);
        pcButton.setOnAction(e -> {
            inventory.buyPc();
            if (inventory.hasPc()) {
                betButton.setVisible(true);
                fasterButton.setVisible(true);
                ecommerceButton.setVisible(true);
            }
        });
        
        Button houseButton = new Button("Buy a House - $1.000");
        houseButton.setOnAction(e -> {
            inventory.buyHouse();
            if (inventory.hasHouse()) {
                pcButton.setVisible(true);
            }
        });

        // Add to grid
        grid.add(hatButton, 0, 0);
        grid.add(guitarButton, 0, 1);
        grid.add(houseButton, 0, 2);
        grid.add(pcButton, 0, 3);
        grid.add(ecommerceButton, 0, 4);
        grid.add(churchButton, 0, 5);
        grid.add(betButton, 1, 0);
        grid.add(fasterButton, 1, 1);

        // Root
        BorderPane root = new BorderPane();
        root.setTop(label);
        BorderPane.setAlignment(label, Pos.CENTER);
        root.setCenter(grid);

        stage.setScene(new Scene(root, 400, 300));
        stage.show();
    }
}
