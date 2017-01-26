package com.atma.superpomo.service.timers;

import com.atma.superpomo.model.TimerType;
import com.atma.superpomo.service.PomoTimerTask;

import java.util.TimerTask;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public class SecondTimer extends PomoTimer {

    public static final int SECOND_MILLIS = 1000;

    public SecondTimer() {
        super();
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
