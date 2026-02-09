package br.com.git.clicker_game.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import lombok.Data;

@Data
public class Count {
    
    private IntegerProperty count = new SimpleIntegerProperty(11000);

    public int getCount() {
        return count.get();
    }

    public void setCount(int value) {
        count.set(value);
    }

    public IntegerProperty countProperty() {
        return count;
    }

    public void increment() {
        count.set(count.get() + 1);
    }

    public void decrement() {
        count.set(count.get() - 1);
    }



}
