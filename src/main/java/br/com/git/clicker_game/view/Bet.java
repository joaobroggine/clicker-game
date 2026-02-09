package br.com.git.clicker_game.view;

import br.com.git.clicker_game.core.GameManager;
import br.com.git.clicker_game.model.Count;
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
            
            GameManager.setBetScreen(stage);

        }

}
