package com.atma.superpomo.gui.controller;

import com.atma.superpomo.model.Pomodoro;
import com.atma.superpomo.service.tasks.MinutePomoTask;
import com.atma.superpomo.service.tasks.SecondPomoTask;
import com.atma.superpomo.service.timer.PomoTimerTask;
import com.atma.superpomo.service.timer.PomoTimerTaskListener;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by diego.pessoa on 30/01/2017.
 */
public class PrincipalUIController implements Initializable, PomoTimerTaskListener {

    @FXML
    private Label fillLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(()->{
            Pomodoro p = new Pomodoro();
            p.setPomoClock(new Date());

            SecondPomoTask st = new SecondPomoTask(p);
            st.addPomoTimerTaskListener(this);
            st.start();
        });

//        Task task = new Task() {
//            @Override
//            protected Object call() throws Exception {
//                return null;
//            }
//        };
//
//        new Thread(task).start();
    }

    @Override
    public void taskExecuted(PomoTimerTask pomoTimerTask) {
        System.out.println("teste");
        Platform.runLater(()->{
//            fillLabel.setText("ateste");
            fillLabel.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(pomoTimerTask.getPomodoro().getPomoClock()));
        });
//        fillLabel.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(pomoTimerTask.getPomodoro().getPomoClock()));
    }
}
