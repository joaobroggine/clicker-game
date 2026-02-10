package br.com.git.clicker_game.view;

import br.com.git.clicker_game.core.GameManager;
import br.com.git.clicker_game.core.SoundManager;
import br.com.git.clicker_game.model.Count;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Bet {
    
        private final Count count;
        private Stage stage;

        public Bet(Count count) {
            this.count = count;
        }

        public void show() {

            stage = new Stage();
            stage.setTitle("Bet");
            stage.setResizable(false);
            
            // GameManager
            GameManager.setBetScreen(stage);

            // Label
            Label label = new Label("777 BET");
            label.setStyle("-fx-font-size: 24px; -fx-text-fill: #333; -fx-font-weight: bold;");

            Label infoLabel = new Label("Bet with responsibility!");
            infoLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #666;");

            Label betLabel = new Label("Enter your bet amount:");
            betLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #333;");

            // Bet Placeholder
            TextField betField = new TextField();
            betField.setMaxWidth(160);

            TextFormatter<String> formatter = new TextFormatter<>(change -> {
                String newText = change.getControlNewText();
                if (newText.matches("\\d*")) {
                    return change;
                }
                return null;
            });
            
            betField.setTextFormatter(formatter);

            // Buttons
            Button betButton = new Button("Place Bet");
            betButton.setOnAction(e -> {
                String betText = betField.getText();
                if (!betText.isEmpty()) {
                    int betAmount = Integer.parseInt(betText);
                    if (betAmount > 0 && betAmount <= count.getCount()) {
                        boolean win = Math.random() < 0.30; // 30% chance to win
                        if (win) {
                            count.setCount(count.getCount() + (betAmount * 2));
                            SoundManager.playSfx("/assets/sounds/sfx/cashmoney.wav", false);
                            javafx.animation.PauseTransition pause = new javafx.animation.PauseTransition(javafx.util.Duration.millis(500));
                            pause.setOnFinished(e2 -> {
                                infoLabel.setText("Congratulations! You won " + betAmount * 2 + "!");
                            });
                            pause.play();
                        } else {
                            count.setCount(count.getCount() - betAmount);
                            infoLabel.setText("Sorry, you lost " + betAmount + ". Try again!");
                        }
                    } else {
                        if (count.getCount() == 0) {
                            infoLabel.setText("You have no money to bet!");
                            javafx.animation.PauseTransition pause = new javafx.animation.PauseTransition(javafx.util.Duration.millis(2000));
                            pause.setOnFinished(e2 -> {
                                infoLabel.setText("Bet with responsibility!");
                            });
                            pause.play();
                        } else {
                            infoLabel.setText("Invalid bet amount! Must be between 1 and " + count.getCount());
                            javafx.animation.PauseTransition pause = new javafx.animation.PauseTransition(javafx.util.Duration.millis(2000));
                            pause.setOnFinished(e2 -> {
                                infoLabel.setText("Bet with responsibility!");
                            });
                            pause.play();
                        }
                    }
                } else {
                    infoLabel.setText("Please enter a bet amount!");
                    javafx.animation.PauseTransition pause = new javafx.animation.PauseTransition(javafx.util.Duration.millis(2000));
                            pause.setOnFinished(e2 -> {
                                infoLabel.setText("Bet with responsibility!");
                            });
                            pause.play();
                }
            });

            // Layout
            VBox box = new VBox(20, label, infoLabel, betLabel, betField, betButton);
            box.setAlignment(Pos.CENTER);
            box.setPadding(new javafx.geometry.Insets(20));

            stage.setScene(new Scene(box, 400, 300));
            stage.show();

        }

}
