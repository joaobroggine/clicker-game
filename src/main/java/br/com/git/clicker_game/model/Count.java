package br.com.git.clicker_game.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import lombok.Data;

@Data
public class Count {
    
    private IntegerProperty count = new SimpleIntegerProperty(120000);
    private Inventory inventory;

    public Count() {
        this.inventory = inventory;
    }

    public int getCount() {
        return count.get();
    }

    public void setCount(int value) {
        count.set(value);
    }

    public IntegerProperty countProperty() {
        return count;
    }

    public int increment() {
        if (inventory.hasFasterClick()) {
            count.set(count.get() + 100);
            return count.get();
        }
        else {
            count.set(count.get() + 1);
            return count.get();
        }
    }

    public int decrement() {
        count.set(count.get() - 1);
        return count.get();
    }



}
