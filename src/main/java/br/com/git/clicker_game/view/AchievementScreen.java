package br.com.git.clicker_game.view;

import br.com.git.clicker_game.core.AchievementManager;
import br.com.git.clicker_game.core.GameManager;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AchievementScreen {
    
    private Stage stage;
    private AchievementManager achievementManager = new AchievementManager();

    int row = 0;

    public AchievementScreen(AchievementManager achievementManager) {
        this.achievementManager = achievementManager;
    }

    public void show() {
        stage = new Stage();
        stage.setTitle("Achievements");
        stage.setResizable(false);

        // GameManager
        GameManager.setAchievementScreen(stage);

        // Grid
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        
        // Label
        Label label = new Label("Achievements");
        label.setStyle("-fx-font-size: 24px; -fx-text-fill: #333; -fx-font-weight: bold;");
        for (var achievement : achievementManager.getAchievements()) {
            Label AchievementsTitle = new Label(achievement.getName());
            AchievementsTitle.setStyle("-fx-font-size: 18px; -fx-text-fill: #666; -fx-font-weight: bold;");
            Label AchievementDescription = new Label(achievement.getDescription());
            AchievementDescription.setStyle("-fx-font-size: 14px; -fx-text-fill: #999;");
            
            VBox achievementBox = new VBox(5);
            achievementBox.getChildren().addAll(AchievementsTitle, AchievementDescription);

            // Add to grid
            grid.add(achievementBox, 0, row);
            row++;
        }



        // Root
        BorderPane root = new BorderPane();
        root.setTop(label);
        BorderPane.setAlignment(label, Pos.CENTER);
        root.setCenter(grid);

        stage.setScene(new Scene(root, 400, 300));
        stage.show();
        
    }

}
