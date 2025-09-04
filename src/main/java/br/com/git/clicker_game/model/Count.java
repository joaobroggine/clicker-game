package br.com.git.clicker_game.model;

import lombok.Data;

@Data
public class Count {
    
    private int count;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

}
