package controller.transactionController;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainBarrowingController {
    @FXML
    private AnchorPane root;

    @FXML
    void btnBarrowBooksOnAction(ActionEvent event) throws IOException {
        URL source2 = getClass().getResource("/View/NewBarrowingBook.fxml");
        Parent root = FXMLLoader.load(source2);
        //Parent root = FXMLLoader.load(this.getClass().getResource("/View/signUp.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
 
        stage.setTitle("Barrowing Book");
        stage.show();

    }

    @FXML
    void btnRetainBooksOnAction(ActionEvent event) throws IOException {
        URL source2 = getClass().getResource("/View/RetainBook.fxml");
        Parent root = FXMLLoader.load(source2);
        //Parent root = FXMLLoader.load(this.getClass().getResource("/View/signUp.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
 
        stage.setTitle("Retain Book");
        stage.show();

    }
}
