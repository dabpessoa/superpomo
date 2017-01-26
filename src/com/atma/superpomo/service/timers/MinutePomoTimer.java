package com.atma.superpomo.service.timers;

import com.atma.superpomo.model.enums.TimerType;
import com.atma.superpomo.service.PomoTimerTask;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public class MinutePomoTimer extends PomoTimer {

    public static final int MINUTE_MILLIS = 1000*60;

    public MinutePomoTimer() {
        super();
    }

    public MinutePomoTimer(boolean daemon) {
        super(daemon);
    }

    public MinutePomoTimer(String name, boolean isDaemon) {
        super(name, isDaemon);
    }

    public MinutePomoTimer(String name, long milliSecondsDelay, boolean isDaemon) {
        super(name, milliSecondsDelay, isDaemon);
    }

    @Override
    public void start(PomoTimerTask task) {
        getTimer().schedule(task, getMilliSecondsDelay(), MINUTE_MILLIS);
    }

    @Override
    public TimerType getTimerType() {
        return TimerType.MINUTE;
    }
}
