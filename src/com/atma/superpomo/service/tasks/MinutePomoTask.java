package com.atma.superpomo.service.tasks;

import com.atma.superpomo.service.timer.TimerTask;
import com.atma.superpomo.service.timer.TimerTaskListener;
import com.atma.superpomo.service.timer.timers.MinuteTimer;

/**
 * Created by diego.pessoa on 26/01/2017.
 */
public class MinutePomoTask extends TimerTask implements TimerTaskListener {

    private MinuteTimer minutePomoTimer;

    public MinutePomoTask() {
        addPomoTimerTaskListener(this);
        minutePomoTimer = new MinuteTimer(false);
    }

    public void start() {
        minutePomoTimer.start(this);
    }

    @Override
    public void doJob() {
        System.out.println("MINUTE task executando...");
    }

    @Override
    public void taskExecuted(TimerTask pomoTimerTask) {
        System.out.println("MINUTE task executed!");
    }
}
