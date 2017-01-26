package com.atma.superpomo.service.timer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public abstract class TimerTask extends java.util.TimerTask {

    private String name;
    private List<TimerTaskListener> pomoTimerTaskListeners;

    public TimerTask() {
        this(null);
    }

    public TimerTask(String name) {
        this.name = name;
        this.pomoTimerTaskListeners = new ArrayList<>();
    }

    public abstract void doJob();

    @Override
    public void run() {
        doJob();
        updatePomoTimerTaskListeners();
    }

    public void addPomoTimerTaskListener(TimerTaskListener pomoTimerListener) {
        if (!pomoTimerTaskListeners.contains(pomoTimerListener)) {
            this.pomoTimerTaskListeners.add(pomoTimerListener);
        }
    }

    public void updatePomoTimerTaskListeners() {
        for (TimerTaskListener updateTimeListener : pomoTimerTaskListeners) {
            updateTimeListener.taskExecuted(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
