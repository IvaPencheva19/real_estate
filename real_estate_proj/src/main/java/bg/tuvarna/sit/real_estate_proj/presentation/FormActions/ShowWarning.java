package bg.tuvarna.sit.real_estate_proj.presentation.FormActions;

import javafx.scene.control.Alert;

public class ShowWarning {
    public static void showWarning(String warn){
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setContentText(warn);
        a.show();
    }
    public static void showInformation(String warn){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(warn);
        a.show();
    }
}
