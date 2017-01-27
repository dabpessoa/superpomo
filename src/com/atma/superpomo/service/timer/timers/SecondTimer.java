package com.atma.superpomo.service.timer.timers;

import com.atma.superpomo.model.enums.TimerType;
import com.atma.superpomo.service.timer.PomoTimerTask;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public class SecondTimer extends Timer {

    public static final int SECOND_MILLIS = 1000;

    public SecondTimer() {
        this(true);
    }

    public SecondTimer(boolean daemon) {
        super(daemon);
    }

    public SecondTimer(String name, boolean isDaemon) {
        super(name, isDaemon);
    }

    public SecondTimer(String name, long milliSecondsDelay, boolean isDaemon) {
        super(name, milliSecondsDelay, isDaemon);
    }

    @Override
    public void start(PomoTimerTask task) {
        getTimer().schedule(task, getMilliSecondsDelay(), SECOND_MILLIS);
    }

    @Override
    public TimerType getTimerType() {
        return TimerType.SECOND;
    }

}
