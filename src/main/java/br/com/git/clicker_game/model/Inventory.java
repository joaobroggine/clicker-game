package br.com.git.clicker_game.model;

import javax.swing.JOptionPane;

import javafx.application.Platform;

public class Inventory {
    
    private int hat = 0;
    private Count count;
    private boolean incomeThreadStarted = false;

    public Inventory(Count count) {
        this.count = count;
    }

    public void buyHat() {
        int hatPrice = 10;
        if (count.getCount() >= hatPrice) {
            hat++;
            JOptionPane.showMessageDialog(null, "Now, the peoples can spare change for you!");
            count.setCount(count.getCount() - hatPrice);
            startHatIncome();
        } else {
            JOptionPane.showMessageDialog(null, "You don't have enough money to buy a hat!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void startHatIncome() {
        if (incomeThreadStarted == true) {
            return;
        } else {
            incomeThreadStarted = true;
        }

        new Thread(() -> {
            while (true) {
                if (hat > 0) {
                    Platform.runLater(() -> {
                        for (int i = 0; i < hat; i++) {
                            count.increment();
                        }
                    });
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public int getMoneyWithHat() {
        return count.getCount();
    }

    public int getHat() {
        return hat;
    }
}
