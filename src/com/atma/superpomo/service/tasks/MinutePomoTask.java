package com.atma.superpomo.service.tasks;

import com.atma.superpomo.service.PomoTimerTask;
import com.atma.superpomo.service.PomoTimerTaskListener;
import com.atma.superpomo.service.timers.MinutePomoTimer;
import com.atma.superpomo.service.timers.SecondPomoTimer;

/**
 * Created by diego.pessoa on 26/01/2017.
 */
public class MinutePomoTask extends PomoTimerTask implements PomoTimerTaskListener {

    private MinutePomoTimer minutePomoTimer;

    public MinutePomoTask() {
        addPomoTimerTaskListener(this);
        minutePomoTimer = new MinutePomoTimer(false);
    }

    public void start() {
        minutePomoTimer.start(this);
    }

    @Override
    public void doJob() {
        System.out.println("MINUTE task executando...");
    }

    @Override
    public void taskExecuted(PomoTimerTask pomoTimerTask) {
        System.out.println("MINUTE task executed!");
    }
}
