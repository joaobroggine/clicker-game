package br.com.git.clicker_game.view;

import br.com.git.clicker_game.core.AchievementManager;
import br.com.git.clicker_game.core.GameManager;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
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
        grid.setPadding(new javafx.geometry.Insets(0, 0, 0, 10));
        
        // Label
        Label label = new Label("Achievements");
        label.setStyle("-fx-font-size: 24px; -fx-text-fill: #333; -fx-font-weight: bold;");
        for (var achievement : achievementManager.getAchievements()) {
            Label AchievementsTitle = new Label(achievement.getName());
            AchievementsTitle.setStyle("-fx-font-size: 16px; -fx-text-fill: #666; -fx-font-weight: bold;");
            
            // Textos independentes
            Text AchievementDescription = new Text(achievement.getDescription() + " | ");
            AchievementDescription.setStyle("-fx-font-size: 12px; -fx-fill: #999;");
            Text AchievementStatus = new Text(achievement.isUnlocked() ? "Unlocked" : "Locked");
            AchievementStatus.setStyle("-fx-font-size: 12px; -fx-fill: " + (achievement.isUnlocked() ? "#4CAF50;" : "#F44336;"));
            TextFlow flow = new TextFlow(AchievementDescription, AchievementStatus);

            VBox achievementBox = new VBox(2);
            achievementBox.getChildren().addAll(AchievementsTitle, flow);

            // Add to grid
            grid.add(achievementBox, 0, row);
            row++;
        }

        // ScrollPane
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(grid);
        scrollPane.setFitToWidth(true);
        scrollPane.setPannable(true);

        // Root
        BorderPane root = new BorderPane();
        root.setTop(label);
        BorderPane.setAlignment(label, Pos.CENTER);
        root.setCenter(scrollPane);

        stage.setScene(new Scene(root, 400, 300));
        stage.show();
        
    }

}
