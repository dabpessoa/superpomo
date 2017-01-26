package com.atma.superpomo.service.timers;

import com.atma.superpomo.model.TimerType;
import com.atma.superpomo.service.PomoTimerTask;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public abstract class PomoTimer {

    private String name;
    private Timer timer;
    private long milliSecondsDelay;
    private boolean daemon;

    public PomoTimer() {
        this(null, false);
    }

    public PomoTimer(String name, boolean daemon) {
        this(name, 0L, daemon);
    }

    public PomoTimer(String name, long milliSecondsDelay, boolean daemon) {
        this.name = name;
        this.milliSecondsDelay = milliSecondsDelay;
        this.daemon = daemon;
        this.timer = name != null ? new Timer(name, daemon) : new Timer(daemon);
    }

    public abstract void start(PomoTimerTask task);
    public abstract TimerType getTimerType();

    public Timer getTimer() {
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

}
