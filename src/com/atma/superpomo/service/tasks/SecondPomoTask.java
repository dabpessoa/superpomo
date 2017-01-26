package com.atma.superpomo.service.tasks;

import com.atma.superpomo.model.Pomodoro;
import com.atma.superpomo.model.enums.TimerType;
import com.atma.superpomo.service.timer.TimerTask;
import com.atma.superpomo.service.timer.TimerTaskListener;
import com.atma.superpomo.service.timer.timers.SecondTimer;

/**
 * Created by diego.pessoa on 26/01/2017.
 */
public class SecondPomoTask extends TimerTask {

    private SecondTimer secondPomoTimer;
    private Pomodoro pomodoro;

    public SecondPomoTask(Pomodoro pomodoro) {
        this.pomodoro = pomodoro;
        secondPomoTimer = new SecondTimer(false);
    }

    public void start() {
        secondPomoTimer.start(this);
    }

    @Override
    public void doJob() {
        if (!pomodoro.isFinished()) {
            pomodoro.updateDurationTaskTime(secondPomoTimer.getTimerType(), -1);
        }
    }

}
