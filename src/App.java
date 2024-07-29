

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        System.out.println("Hi library");
        launch(args);
    }

    @Override
    public void start(Stage firstStage) throws Exception {
        // TODO Auto-generated method stub
        URL source = getClass().getResource("/View/Main.fxml");
        Parent root = FXMLLoader.load(source);
        firstStage.setScene(new Scene(root));

        firstStage.setTitle("Library of IJSE");
        firstStage.show();

        
    }
}
