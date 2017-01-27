package com.atma.superpomo.service.timer.timers;

import com.atma.superpomo.model.enums.TimerType;
import com.atma.superpomo.service.timer.PomoTimerTask;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public class MinuteTimer extends Timer {

    public static final int MINUTE_MILLIS = 1000*60;

    public MinuteTimer() {
        super();
    }

    public MinuteTimer(boolean daemon) {
        super(daemon);
    }

    public MinuteTimer(String name, boolean isDaemon) {
        super(name, isDaemon);
    }

    public MinuteTimer(String name, long milliSecondsDelay, boolean isDaemon) {
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
