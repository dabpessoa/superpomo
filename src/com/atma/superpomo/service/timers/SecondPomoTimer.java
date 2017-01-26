package com.atma.superpomo.service.timers;

import com.atma.superpomo.model.enums.TimerType;
import com.atma.superpomo.service.PomoTimerTask;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public class SecondPomoTimer extends PomoTimer {

    public static final int SECOND_MILLIS = 1000;

    public SecondPomoTimer() {
        this(true);
    }

    public SecondPomoTimer(boolean daemon) {
        super(daemon);
    }

    public SecondPomoTimer(String name, boolean isDaemon) {
        super(name, isDaemon);
    }

    public SecondPomoTimer(String name, long milliSecondsDelay, boolean isDaemon) {
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
