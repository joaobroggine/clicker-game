package br.com.git.clicker_game.model;

import br.com.git.clicker_game.utils.DialogUtils;
import javafx.application.Platform;

public class Inventory {
    
    private int hat = 0;
    private int guitar = 0;
    private int house = 0;
    private int pc = 0;
    private int ecommerce = 0;
    private int church = 0;
    private int fasterClick = 0;
    private Count count;
    private boolean incomeHatThreadStarted = false;
    private boolean incomeGuitarThreadStarted = false;
    private boolean incomePcThreadStarted = false;

    DialogUtils dialogUtils = new DialogUtils();

    public Inventory(Count count) {
        this.count = count;
    }

    // Hat

    public void buyHat() {
        int hatPrice = 10;
        if (count.getCount() >= hatPrice) {
            hat++;
            DialogUtils.showInfo("Congratulations", "Now, the peoples can spare change for you!");
            count.setCount(count.getCount() - hatPrice);
            startHatIncome();
        } else {
            DialogUtils.showWarning("Warning", "You don't have enough money to buy a hat!");
        }
    }

    private void startHatIncome() {
        if (incomeHatThreadStarted == true) {
            return;
        } else {
            incomeHatThreadStarted = true;
        }

        new Thread(() -> {
            while (true) {
                if (hasHat()) {
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

    public boolean hasHat() {
        return hat > 0;
    }

    // Guitar

    public void buyGuitar() {
        int guitarPrice = 150;
        if (count.getCount() >= guitarPrice) {
            guitar++;
            DialogUtils.showInfo("Congratulations", "Now, you're playing Set It On songs to earn money!");
            count.setCount(count.getCount() - guitarPrice);
            startGuitarIncome();
        } else {
            DialogUtils.showWarning("Warning", "You don't have enough money to buy a guitar!");
        }
    }

    private void startGuitarIncome() {
        if (incomeGuitarThreadStarted == true) {
            return;
        } else {
            incomeGuitarThreadStarted = true;
        }

        new Thread(() -> {
            while (true) {
                if (hasGuitar()) {
                    Platform.runLater(() -> {
                        for (int i = 0; i < guitar; i++) {
                            count.setCount(count.getCount() + 5);
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

    public boolean hasGuitar() {
        return guitar > 0;
    }

    // House

    public void buyHouse() {
        int housePrice = 1000;
        if (count.getCount() >= housePrice) {
            house++;
            DialogUtils.showInfo("Congratulations", "Congratulations, your house doesn’t make money by itself, but it opens the door to new opportunities!");
            count.setCount(count.getCount() - housePrice);
        } else {
            DialogUtils.showWarning("Warning", "You don't have enough money to buy a house!");
        }
    }

    public boolean hasHouse() {
        return house > 0;
    }

    // PC

    public void buyPc() {
        int pcPrice = 5000;
        if (count.getCount() >= pcPrice) {
            pc++;
            DialogUtils.showInfo("Congratulations", "Congratulations, your PC is making money for you while you sleep!");
            count.setCount(count.getCount() - pcPrice);
            startPcIncome();
        } else {
            DialogUtils.showWarning("Warning", "You don't have enough money to buy a PC!");
        }
    }

    private void startPcIncome() {
        if (incomePcThreadStarted == true) {
            return;
        } else {
            incomePcThreadStarted = true;
        }

        new Thread(() -> {
            while (true) {
                if (hasPc()) {
                    Platform.runLater(() -> {
                        for (int i = 0; i < pc; i++) {
                            count.setCount(count.getCount() + 100);
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

    public boolean hasPc() {
        return pc > 0;
    }

    // Faster Click

    public void buyFasterClick() {
        int fasterClickPrice = 5000;
        if (count.getCount() >= fasterClickPrice) {
            fasterClick++;
            DialogUtils.showInfo("Congratulations", "Congratulations, your clicks gains 100x more money!");
            count.setCount(count.getCount() - fasterClickPrice);
        } else {
            DialogUtils.showWarning("Warning", "You don't have enough money to buy a faster click!");
        }
    }

    public boolean hasFasterClick() {
        return fasterClick > 0;
    }

    // E-commerce

    public void buyEcommerce() {
        int ecommercePrice = 10000;
        if (count.getCount() >= ecommercePrice) {
            ecommerce++;
            DialogUtils.showInfo("Congratulations", "Congratulations, you opened an small e-commerce");
            count.setCount(count.getCount() - ecommercePrice);
            startEcommerceIncome();
        } else {
            DialogUtils.showWarning("Warning", "You don't have enough money to buy an e-commerce!");
        }
    }

    private void startEcommerceIncome() {
    new Thread(() -> {
        while (true) {
            if (hasEcommerce()) {
                Platform.runLater(() -> {
                    count.setCount(count.getCount() + 500);
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

    public boolean hasEcommerce() {
        return ecommerce > 0;
    }

    public void buyChurch() {
        int churchPrice = 50000;
        if (count.getCount() >= churchPrice) {
            church++;
            DialogUtils.showInfo("Congratulations", "Congratulations, a church has been built, and now donations can be received from the faithful! You made your own religion.");
            count.setCount(count.getCount() - churchPrice);
            startChurchIncome();
        } else {
            DialogUtils.showWarning("Warning", "You don't have enough money to buy a church!");
        }
    }

    private void startChurchIncome() {
        new Thread(() -> {
            while (true) {
                if (hasChurch()) {
                    Platform.runLater(() -> {
                        count.setCount(count.getCount() + 1000);
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

    public boolean hasChurch() {
        return church > 0;
    }    

}