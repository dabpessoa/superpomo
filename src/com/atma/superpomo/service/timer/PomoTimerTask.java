package com.atma.superpomo.service.timer;

import com.atma.superpomo.model.Pomodoro;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public abstract class PomoTimerTask extends TimerTask {

    private String taskName;
    private Pomodoro pomodoro;
    private PomoTimer pomoTimer;
    private List<PomoTimerTaskListener> pomoTimerTaskListeners;
    private Runnable runnable;
    private boolean running;

    public PomoTimerTask() {
        this(null);
    }

    public PomoTimerTask(Pomodoro pomodoro) {
        this(pomodoro, null);
    }

    public PomoTimerTask(Pomodoro pomodoro, String taskName) {
        this.running = false;
        this.taskName = taskName;
        this.pomodoro = pomodoro;
        this.pomoTimerTaskListeners = new ArrayList<>();
    }

    public abstract void start();
    public abstract void doJob();

    @Override
    public void run() {
        try {
            running = true;
            if (getRunnable() != null) {
                getRunnable().run();
            } else {
                doJob();
            }
            updatePomoTimerTaskListeners();
        } finally {
            running = false;
        }
    }

    @Override
    public boolean cancel() {
        boolean cancelBoolean = super.cancel();
        running = false;
        return cancelBoolean;
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

    public boolean isRunning() {
        return running;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

}
