package com.atma.superpomo.service;

import com.atma.superpomo.service.timers.PomoTimer;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public abstract class PomoTimerTask extends TimerTask {

    private PomoTimer pomoTimer;
    private List<UpdateTimeListener> updateTimeListeners;

    public PomoTimerTask(PomoTimer pomoTimer) {
        this.pomoTimer = pomoTimer;
    }

    public PomoTimerTask() {
        this.updateTimeListeners = new ArrayList<>();
    }

    public abstract void doJob();

    @Override
    public void run() {
        doJob();
        updateTimeListeners();
    }

    public void addTimeListener(UpdateTimeListener updateTimeListener) {
        this.updateTimeListeners.add(updateTimeListener);
    }

    public void updateTimeListeners() {
        for (UpdateTimeListener updateTimeListener : updateTimeListeners) {
            updateTimeListener.updateTime(pomoTimer);
        }
    }

}
