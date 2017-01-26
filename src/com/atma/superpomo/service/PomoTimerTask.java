package com.atma.superpomo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public abstract class PomoTimerTask extends TimerTask {

    private String name;
    private List<PomoTimerTaskListener> pomoTimerTaskListeners;

    public PomoTimerTask() {
        this(null);
    }

    public PomoTimerTask(String name) {
        this.name = name;
        this.pomoTimerTaskListeners = new ArrayList<>();
    }

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

    public void updatePomoTimerTaskListeners() {
        for (PomoTimerTaskListener updateTimeListener : pomoTimerTaskListeners) {
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
