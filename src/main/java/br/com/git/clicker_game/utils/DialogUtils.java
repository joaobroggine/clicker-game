package br.com.git.clicker_game.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DialogUtils {

    private static void show(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showInfo(String title, String message) {
        show(AlertType.INFORMATION, title, message);
    }

    public static void showWarning(String title, String message) {
        show(AlertType.WARNING, title, message);
    }

    public static void showError(String title, String message) {
        show(AlertType.ERROR, title, message);
    }

}
