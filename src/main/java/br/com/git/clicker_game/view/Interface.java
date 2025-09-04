package br.com.git.clicker_game.view;

import br.com.git.clicker_game.model.Count;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class Interface extends Application {

    Count count = new Count();

    @Override
    public void start(javafx.stage.Stage stage) throws Exception {

        // Labels

        Label label = new Label("Clicker Game!");
        label.setStyle("-fx-font-size: 24px; -fx-text-fill: #333; -fx-font-weight: bold;");
        label.setTranslateY(-30);

        Label moneyLabel = new Label("Money: 0");
        moneyLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: #666;");


        // End of labels

        // Buttons

        Button farmButton = new Button("Get Money");
        farmButton.setOnAction(e -> {
            count.increment();
            moneyLabel.setText("Money: " + count.getCount());
        });

        // End of buttons

        StackPane root = new StackPane(label);
        root.getChildren().add(moneyLabel);
        
        root.getChildren().add(farmButton);
        StackPane.setAlignment(farmButton, javafx.geometry.Pos.BOTTOM_CENTER);

        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("Clicker Game");
        stage.setScene(scene);
        stage.show();
    }

}
