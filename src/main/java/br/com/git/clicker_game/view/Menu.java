package br.com.git.clicker_game.view;

import javax.swing.JOptionPane;

import br.com.git.clicker_game.model.Inventory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Menu extends Application {

    Inventory inventory;

    public Menu(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void start(javafx.stage.Stage stage) throws Exception {
        
        // Labels

        Label label = new Label("Shop");
        label.setStyle("-fx-font-size: 24px; -fx-text-fill: #333; -fx-font-weight: bold;");

        // End of labels

        // Buttons

        Button hatButton = new Button("Buy a Hat - 10 Money");
        hatButton.setStyle("-fx-font-size: 16px;");
        hatButton.setOnAction(e -> {
            inventory.buyHat();
            JOptionPane.showMessageDialog(null, "Now, the peoples can spare change for you!");
        });

        // End of buttons

        VBox box = new VBox(10);
        box.getChildren().addAll(label, hatButton);

        Scene scene = new Scene(box, 400, 300);

        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.setMaximized(false);
        stage.setTitle("Shop");
        stage.setScene(scene);
        stage.show();
    }
}
