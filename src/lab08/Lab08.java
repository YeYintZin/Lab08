package lab08;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Lab08 extends Application {

    public static void main(String[] args) {
        Application.launch(Lab08.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Lab08-YeYintZin");
        stage.setScene(scene);
        stage.show();
    }
    
}
