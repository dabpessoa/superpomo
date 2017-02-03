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

    @FXML
    private Button stopButton;

    private SecondPomoTask secondPomoTask;

    public PrincipalUIController() {}

    public void startPomodoro(ActionEvent event) {
        if (secondPomoTask != null) secondPomoTask.cancel();
        initPomoTask();
        Platform.runLater(()->{
            secondPomoTask.start();
        });
    }

    public void stopPomodoro(ActionEvent event) {
        if (secondPomoTask != null) secondPomoTask.cancel();
    }

    public void pausePomodoro(ActionEvent event) {
        if (secondPomoTask != null) {
            secondPomoTask.cancel();
            secondPomoTask.getPomodoro().pause();
        }
    }

    public void initPomoTask() {
        Pomodoro pomodoro = null;
        if (secondPomoTask != null) {
            if (secondPomoTask.getPomodoro() != null && secondPomoTask.getPomodoro().isPaused()) {
                pomodoro = secondPomoTask.getPomodoro();
                pomodoro.resume();
            }
        }

        if (pomodoro == null) {
            pomodoro = new Pomodoro();
            pomodoro.setPomoClock(new Date());
        }

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
