package com.atma.superpomo.service.tasks;

import com.atma.superpomo.service.PomoTimerTask;
import com.atma.superpomo.service.PomoTimerTaskListener;
import com.atma.superpomo.service.timers.SecondPomoTimer;

/**
 * Created by diego.pessoa on 26/01/2017.
 */
public class SecondPomoTask extends PomoTimerTask implements PomoTimerTaskListener {

    private SecondPomoTimer secondPomoTimer;

    public SecondPomoTask() {
        addPomoTimerTaskListener(this);
        secondPomoTimer = new SecondPomoTimer(false);
    }

    public void start() {
        secondPomoTimer.start(this);
    }

    @Override
    public void doJob() {
        System.out.println("SECOND task executando...");
    }

    @Override
    public void taskExecuted(PomoTimerTask pomoTimerTask) {
        System.out.println("SECOND task executed!");
    }

}
