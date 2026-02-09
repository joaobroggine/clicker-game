package br.com.git.clicker_game.view;

import br.com.git.clicker_game.core.GameManager;
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

    private Count count = new Count();
    private Inventory inventory = new Inventory(count);

    @Override
    public void start(Stage stage) {

        GameManager.setMainStage(stage);

        Scene mainScene = createScene();
        stage.setScene(mainScene);
        stage.setTitle("Job Clicker");
        stage.setResizable(false);
        stage.show();
        
        stage.setOnCloseRequest(e -> {
            System.exit(0);
        });

    }

    public Scene createScene() {

        // Labels
        Label label = new Label("Job Clicker");
        label.setStyle("-fx-font-size: 24px; -fx-text-fill: #333; -fx-font-weight: bold;");

        Label moneyLabel = new Label();
        moneyLabel.textProperty().bind(count.countProperty().asString("Money: %d"));
        moneyLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: #666;");

        // Buttons
        Button farmButton = new Button("Get Money");
        farmButton.setOnAction(e -> count.increment());

        Button shopButton = new Button("Shop");
        shopButton.setOnAction(e -> {
            Menu menu = new Menu(inventory, count);
            menu.show();
        });

        // Layout
        VBox box = new VBox(15, label, moneyLabel, farmButton, shopButton);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(20));

        return new Scene(box, 400, 300);
    }
}
