package com.atma.superpomo.service.timer.timers;

import com.atma.superpomo.model.enums.TimerType;
import com.atma.superpomo.service.timer.TimerTask;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public class HourTimer extends Timer {

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
    public void start(TimerTask task) {
        getTimer().schedule(task, getMilliSecondsDelay(), HOUR_MILLIS);
    }

    @Override
    public TimerType getTimerType() {
        return TimerType.HOUR;
    }
}
