package com.atma.superpomo.gui;

import com.atma.superpomo.util.JavaFXUtils;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by diego.pessoa on 30/01/2017.
 */
public class PrincipalUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        JavaFXUtils.initStage("Hello World", primaryStage, "fxmls/principalUI.fxml");
        primaryStage.show();
    }

}
