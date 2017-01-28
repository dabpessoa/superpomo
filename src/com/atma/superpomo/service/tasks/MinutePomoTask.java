package com.atma.superpomo.service.tasks;

import com.atma.superpomo.model.Pomodoro;
import com.atma.superpomo.service.timer.PomoTimerTask;
import com.atma.superpomo.service.timer.PomoTimerTaskListener;
import com.atma.superpomo.service.timer.timers.MinuteTimer;

/**
 * Created by diego.pessoa on 26/01/2017.
 */
public class MinutePomoTask extends PomoTimerTask {

    private MinuteTimer minutePomoTimer;

    public MinutePomoTask(Pomodoro pomodoro) {
        super(pomodoro);
        minutePomoTimer = new MinuteTimer(false);
        setPomoTimer(minutePomoTimer);
    }

    public void start() {
        minutePomoTimer.start(this);
    }

    @Override
    public void doJob() {
        if (!getPomodoro().isFinished()) {
            getPomodoro().updatePomoClockTime(minutePomoTimer.getTimerType(), -1);
        }
    }

}
