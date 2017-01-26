package com.atma.superpomo.service.timers;

import com.atma.superpomo.model.TimerType;
import com.atma.superpomo.service.PomoTimerTask;

import java.util.TimerTask;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public class HourTimer extends PomoTimer {

    public static final int HOUR_MILLIS = 1000*60*60;

    public HourTimer() {
        super();
    }

    public HourTimer(String name, boolean isDaemon) {
        super(name, isDaemon);
    }

    public HourTimer(String name, long milliSecondsDelay, boolean isDaemon) {
        super(name, milliSecondsDelay, isDaemon);
    }

    @Override
    public void start(PomoTimerTask task) {
        getTimer().schedule(task, getMilliSecondsDelay(), HOUR_MILLIS);
    }

    @Override
    public TimerType getTimerType() {
        return TimerType.HOUR;
    }
}
