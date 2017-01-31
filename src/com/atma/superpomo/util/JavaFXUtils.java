package com.atma.superpomo.util;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;

/**
 * Created by diego.pessoa on 30/01/2017.
 */
public class JavaFXUtils {

    public static void startStage(String stageTitle, Stage primaryStage, String fxmlsPath) throws IOException {
        URL location = ClassUtils.getDefaultClassLoader(JavaFXUtils.class).getResource(fxmlsPath);
        Parent root = FXMLLoader.load(location);
        primaryStage.setTitle(stageTitle);
        primaryStage.setScene(new Scene(root));

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });

        primaryStage.show();
    }

}
