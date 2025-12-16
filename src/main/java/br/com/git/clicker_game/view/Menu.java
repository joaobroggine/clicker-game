package br.com.git.clicker_game.view;

import br.com.git.clicker_game.core.GameManager;
import br.com.git.clicker_game.model.Inventory;
import br.com.git.clicker_game.view.maingame.MainScreen;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Menu {

    private final Inventory inventory;
    private Stage stage;

    public Menu(Inventory inventory) {
        this.inventory = inventory;
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
        grid.setHgap(10);
        grid.setVgap(10);

        // Buttons
        Button hatButton = new Button("Buy a Hat - 10 Bucks");
        hatButton.setOnAction(e -> inventory.buyHat());

        Button guitarButton = new Button("Buy a Guitar - 150 Bucks");
        guitarButton.setOnAction(e -> inventory.buyGuitar());

        Button pcButton = new Button("Buy a PC - 5000 Bucks");
        pcButton.setVisible(false);
        pcButton.setOnAction(e -> {
            inventory.buyPc();
            if (inventory.hasPc()) {
                GameManager.closeShopScreen();
                GameManager.changeScene(new MainScreen().createScene());
            }
        });

        Button houseButton = new Button("Buy a House - 1000 Bucks");
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

        // Root
        BorderPane root = new BorderPane();
        root.setTop(label);
        BorderPane.setAlignment(label, Pos.CENTER);
        root.setCenter(grid);

        stage.setScene(new Scene(root, 400, 300));
        stage.show();
    }
}
