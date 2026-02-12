package br.com.git.clicker_game.model;

public class Achievement {
    
    private String name;
    private String description;
    private boolean status;

    public Achievement(String name, String description, boolean status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isUnlocked() {
        return status;
    }

    public void unlock() {
        this.status = true;
    }

}
