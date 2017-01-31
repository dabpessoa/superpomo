package com.atma.superpomo.gui.controller;

import com.atma.superpomo.gui.PrincipalUI;
import com.atma.superpomo.model.Pomodoro;
import com.atma.superpomo.service.tasks.MinutePomoTask;
import com.atma.superpomo.service.tasks.SecondPomoTask;
import com.atma.superpomo.service.timer.PomoTimerTask;
import com.atma.superpomo.service.timer.PomoTimerTaskListener;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;

/**
 * Created by diego.pessoa on 30/01/2017.
 */
public class PrincipalUIController implements PomoTimerTaskListener {

    @FXML
    private Label fillLabel;

    @FXML
    private Button startButton;

    private SecondPomoTask secondPomoTask;

    public PrincipalUIController() {}

    public void startPomodoro(ActionEvent event) {
        Platform.runLater(()->{
            if (secondPomoTask != null) secondPomoTask.cancel();
            initPomoTask();
            secondPomoTask.start();
        });
    }

    public void initPomoTask() {
        Pomodoro pomodoro = new Pomodoro();
        pomodoro.setPomoClock(new Date());
        secondPomoTask = new SecondPomoTask(pomodoro);
        secondPomoTask.addPomoTimerTaskListener(this);
    }

    @Override
    public void taskExecuted(PomoTimerTask pomoTimerTask) {
        Platform.runLater(()->{
            fillLabel.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(pomoTimerTask.getPomodoro().getPomoClock()));
        });
    }

}
