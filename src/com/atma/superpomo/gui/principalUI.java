package com.atma.superpomo.gui;

import com.atma.superpomo.gui.controller.PrincipalUIController;
import com.atma.superpomo.util.ClassUtils;
import com.atma.superpomo.util.JavaFXUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Created by diego.pessoa on 30/01/2017.
 */
public class PrincipalUI extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(PrincipalUI.class, (java.lang.String[])null);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        JavaFXUtils.startStage("Hello World", primaryStage, "fxmls/principalUI.fxml");
    }

}
