package com.atma.superpomo.service.timer.timers;

import com.atma.superpomo.model.enums.TimerType;
import com.atma.superpomo.service.timer.PomoTimerTask;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public abstract class Timer {

    private String name;
    private java.util.Timer timer;
    private long milliSecondsDelay;
    private boolean daemon;

    public Timer() {
        this(null, true);
    }

    public Timer(boolean daemon) {
        this(null, daemon);
    }

    public Timer(String name, boolean daemon) {
        this(name, 0L, daemon);
    }

    public Timer(String name, long milliSecondsDelay, boolean daemon) {
        this.name = name;
        this.milliSecondsDelay = milliSecondsDelay;
        this.daemon = daemon;
        this.timer = name != null ? new java.util.Timer(name, daemon) : new java.util.Timer(daemon);
    }

    public abstract void start(PomoTimerTask task);
    public abstract TimerType getTimerType();

    public java.util.Timer getTimer() {
        return timer;
    }

    public String getName() {
        return name;
    }

    public long getMilliSecondsDelay() {
        return milliSecondsDelay;
    }

    public boolean isDaemon() {
        return daemon;
    }

    public void stop() {
        getTimer().cancel();
    }

}
