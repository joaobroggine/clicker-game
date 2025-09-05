package br.com.git.clicker_game.view;

import br.com.git.clicker_game.model.Count;
import br.com.git.clicker_game.model.Inventory;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Interface extends Application {

    Count count = new Count();
    Inventory inventory = new Inventory(count);

    @Override
    public void start(Stage stage) throws Exception {

        // Labels
        Label label = new Label("Clicker Game!");
        label.setStyle("-fx-font-size: 24px; -fx-text-fill: #333; -fx-font-weight: bold;");

        Label moneyLabel = new Label("Money: " + count.getCount());
        moneyLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: #666;");

        // End of labels

        // Buttons

        Button farmButton = new Button("Get Money");
        farmButton.setStyle("-fx-font-size: 12px;");
        farmButton.setOnAction(e -> {
            try {
                count.increment();
                moneyLabel.setText("Money: " + count.getCount());
            } catch (Exception error) {
                error.printStackTrace();
            }
        });

        Button shopButton = new Button("Shop");
        shopButton.setStyle("-fx-font-size: 12px;");
        shopButton.setOnAction(e -> {
            try {
                new Menu(inventory).start(new Stage());
            } catch (Exception error) {
                error.printStackTrace();
            }
        });

        // End of buttons

        VBox box = new VBox(15);
        box.getChildren().addAll(label, moneyLabel, farmButton, shopButton);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(20));

        Scene scene = new Scene(box, 400, 300);

        stage.setOnCloseRequest(e -> {
            System.exit(0);
        });

        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.setMaximized(false);
        stage.setTitle("Clicker Game");
        stage.setScene(scene);
        stage.show();
    }

}
