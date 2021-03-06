package com.atma.superpomo.service.timer.timers;

import com.atma.superpomo.model.enums.TimerType;
import com.atma.superpomo.service.timer.PomoTimerTask;
import com.atma.superpomo.service.timer.PomoTimer;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public class DayTimer  extends PomoTimer {

    public static final int DAY_MILLIS = 1000*60*60*24;

    public DayTimer() {
        super();
    }

    public DayTimer(String name, boolean isDaemon) {
        super(name, isDaemon);
    }

    public DayTimer(String name, long milliSecondsDelay, boolean isDaemon) {
        super(name, milliSecondsDelay, isDaemon);
    }

    @Override
    public void start(PomoTimerTask task) {
        getTimer().schedule(task, getMilliSecondsDelay(), DAY_MILLIS);
    }

    @Override
    public TimerType getTimerType() {
        return TimerType.DAY;
    }
}
