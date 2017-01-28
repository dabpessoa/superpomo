package com.atma.superpomo.service.tasks;

import com.atma.superpomo.model.Pomodoro;
import com.atma.superpomo.service.timer.PomoTimerTask;
import com.atma.superpomo.service.timer.timers.SecondTimer;

/**
 * Created by diego.pessoa on 26/01/2017.
 */
public class SecondPomoTask extends PomoTimerTask {

    private SecondTimer secondPomoTimer;

    public SecondPomoTask(Pomodoro pomodoro) {
        super(pomodoro);
        secondPomoTimer = new SecondTimer(false);
        setPomoTimer(secondPomoTimer);
    }

    @Override
    public void start() {
        getPomoTimer().start(this);
    }

    @Override
    public void doJob() {
        if (!getPomodoro().isFinished()) {
            getPomodoro().updatePomoClockTime(secondPomoTimer.getTimerType(), -1);
        }
    }

}
