package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField textField;

    @FXML
    private Label fillLabel;

    public void clicou(ActionEvent event) {
        String texto = textField.getText();
        fillLabel.setText(texto);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("construindo tela...");
    }

}
