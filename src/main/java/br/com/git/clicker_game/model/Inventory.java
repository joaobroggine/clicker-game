package br.com.git.clicker_game.model;

import lombok.Data;

@Data
public class Inventory {
    
    private int hat = 0;
    private Count count = new Count();

    public Inventory(Count count) {
        this.count = count;
    }

    public void buyHat() {
        if (count.getCount() >= 10) {
            hat++;
            count.setCount(count.getCount() - 10);
            startHatIncome();
        }
    }

    public int startHatIncome() {
        try {
            new Thread(() -> {
                while(true) {
                    if(hat > 0) {
                        count.increment();
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count.getCount();
    }

    public int getMoneyWithHat() {
        return count.getCount();
    }

}
