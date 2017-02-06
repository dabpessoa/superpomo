package com.atma.superpomo.service;

import com.atma.superpomo.model.Pomodoro;
import com.atma.superpomo.model.Usuario;
import com.atma.superpomo.model.enums.TimerType;
import com.atma.superpomo.service.tasks.MinutePomoTask;
import com.atma.superpomo.service.tasks.SecondPomoTask;
import com.atma.superpomo.service.timer.PomoTimerTask;
import com.atma.superpomo.service.timer.PomoTimerTaskListener;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public class PomodoroService implements PomoTimerTaskListener {

    private PomoTimerTask pomoTimerTask;

    public void initPomoCounter() {
        if (pomoTimerTask != null) pomoTimerTask.cancel();
        initPomoTask();
        Platform.runLater(()->{
            pomoTimerTask.start();
        });
    }

    public void initPomoTask() {
        Pomodoro pomodoro = null;
        if (pomoTimerTask != null) {
            if (pomoTimerTask.getPomodoro() != null && pomoTimerTask.getPomodoro().isPaused()) {
                pomodoro = pomoTimerTask.getPomodoro();
                pomodoro.resume();
            }
        }

        if (pomodoro == null) {
            pomodoro = new Pomodoro();
            pomodoro.setPomoClock(new Date());
        }

        pomoTimerTask = new SecondPomoTask(pomodoro);
        pomoTimerTask.addPomoTimerTaskListener(this);
    }

    public void stopPomodoro(ActionEvent event) {
        if (pomoTimerTask != null) pomoTimerTask.cancel();
    }

    public void pausePomodoro(ActionEvent event) {
        if (pomoTimerTask != null) {
            pomoTimerTask.cancel();
            pomoTimerTask.getPomodoro().pause();
        }
    }

    public Work createWork(Usuario usuario) {
        Work work = new Work();
        work.setUsuario(usuario);
        return work;
    }

    public static void main(String[] args) {

        Pomodoro p = new Pomodoro();
        p.setPomoClock(new Date());

        SecondPomoTask st = new SecondPomoTask(p);
        st.addPomoTimerTaskListener(new PomodoroService());

        MinutePomoTask mt = new MinutePomoTask(p);
        mt.addPomoTimerTaskListener(new PomodoroService());

        st.start();
        mt.start();

    }

    @Override
    public void taskExecuted(PomoTimerTask pomoTimerTask) {
        if (pomoTimerTask.getPomoTimer().getTimerType() == TimerType.SECOND) {
            System.out.println("SECOND Time: "+new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(pomoTimerTask.getPomodoro().getPomoClock()));
        } else if (pomoTimerTask.getPomoTimer().getTimerType() == TimerType.MINUTE) {
            System.out.println("MINUTE Time: "+new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(pomoTimerTask.getPomodoro().getPomoClock()));
        }
    }

}
