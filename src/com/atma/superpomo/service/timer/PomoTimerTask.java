package com.atma.superpomo.service.timer;

import com.atma.superpomo.model.Pomodoro;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public abstract class PomoTimerTask extends TimerTask {

    private String taskName;
    private Pomodoro pomodoro;
    private PomoTimer pomoTimer;
    private List<PomoTimerTaskListener> pomoTimerTaskListeners;

    public PomoTimerTask() {
        this(null);
    }

    public PomoTimerTask(Pomodoro pomodoro) {
        this(pomodoro, null);
    }

    public PomoTimerTask(Pomodoro pomodoro, String taskName) {
        this.taskName = taskName;
        this.pomodoro = pomodoro;
        this.pomoTimerTaskListeners = new ArrayList<>();
    }

    public abstract void start();
    public abstract void doJob();

    @Override
    public void run() {
        doJob();
        updatePomoTimerTaskListeners();
    }

    public void addPomoTimerTaskListener(PomoTimerTaskListener pomoTimerListener) {
        if (!pomoTimerTaskListeners.contains(pomoTimerListener)) {
            this.pomoTimerTaskListeners.add(pomoTimerListener);
        }
    }

    private void updatePomoTimerTaskListeners() {
        for (PomoTimerTaskListener updateTimeListener : pomoTimerTaskListeners) {
            updateTimeListener.taskExecuted(this);
        }
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Pomodoro getPomodoro() {
        return pomodoro;
    }

    public void setPomoTimer(PomoTimer pomoTimer) {
        this.pomoTimer = pomoTimer;
    }

    public PomoTimer getPomoTimer() {
        return pomoTimer;
    }

}
