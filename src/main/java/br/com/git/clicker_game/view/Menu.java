package br.com.git.clicker_game.view;

import br.com.git.clicker_game.model.Inventory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class Menu extends Application {

    Inventory inventory;

    public Menu(Inventory inventory) {
        this.inventory = inventory;
    }

    @SuppressWarnings("static-access")
    @Override
    public void start(javafx.stage.Stage stage) throws Exception {
        
        // Labels

        Label label = new Label("Shop");
        label.setStyle("-fx-font-size: 24px; -fx-text-fill: #333; -fx-font-weight: bold;");

        // End of labels

        // Grid

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        
        // End of grid

        // Buttons

        Button hatButton = new Button("Buy a Hat - 10 Bucks");
        hatButton.setStyle("-fx-font-size: 13px;");
        hatButton.setOnAction(e -> {
            inventory.buyHat();
        });

        Button guitarButton = new Button("Buy a Guitar - 150 Bucks");
        guitarButton.setStyle("-fx-font-size: 13px;");
        guitarButton.setOnAction(e -> {
            inventory.buyGuitar();
        });

        Button pcButton = new Button("Buy a PC - 5000 Bucks");
        pcButton.setStyle("-fx-font-size: 13px;");
        pcButton.setVisible(false);
        pcButton.setOnAction(e -> {
            inventory.buyPc();
        });

        Button houseButton = new Button("Buy a House - 1000 Bucks");
        houseButton.setStyle("-fx-font-size: 13px;");
        houseButton.setOnAction(e -> {
            inventory.buyHouse();

            if (inventory.hasHouse()) {
                pcButton.setVisible(true);
            }
        });

        // End of buttons

        // Adding buttons to the grid

        grid.add(hatButton, 0, 0);
        grid.add(guitarButton, 0, 1);
        grid.add(houseButton, 0, 2);
        grid.add(pcButton, 0, 3);

        // End of adding buttons to the grid

        BorderPane root = new BorderPane();
        root.setTop(label);
        root.setAlignment(label, javafx.geometry.Pos.CENTER);
        root.setCenter(grid);

        Scene scene = new Scene(root, 400, 300);

        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.setMaximized(false);
        stage.setTitle("Shop");
        stage.setScene(scene);
        stage.show();
    }
}
