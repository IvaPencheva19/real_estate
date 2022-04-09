package bg.tuvarna.sit.real_estate_proj.presentation.FormActions;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OpenForm {
    public static FXMLLoader openNewForm(String fxmlFileName, String formTitle)
    {
        FXMLLoader fxmlLoad = null;
        try
        {
            fxmlLoad = new FXMLLoader(
                    new OpenForm().getClass().getResource("/bg/tuvarna/sit/real_estate_proj/presentation.views/" + fxmlFileName));
            Parent root = (Parent) fxmlLoad.load();
            Stage stage = new Stage();
            stage.setTitle(formTitle);
            stage.setScene(new Scene(root));
            stage.setResizable(false);

            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Can't load new window. ");
        }
        return fxmlLoad;

    }
}
