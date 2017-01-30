package com.atma.superpomo.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * Created by diego.pessoa on 30/01/2017.
 */
public class JavaFXUtils {

    public static void startStage(Stage primaryStage, String fxmlsPath) throws IOException {
        URL location = ClassUtils.getDefaultClassLoader(JavaFXUtils.class).getResource(fxmlsPath);
        Parent root = FXMLLoader.load(location);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
