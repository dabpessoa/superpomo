package com.atma.superpomo.service;

import com.atma.superpomo.service.timers.PomoTimer;

import java.util.List;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public interface PomoTimerTaskListener {

    void taskExecuted(PomoTimerTask pomoTimerTask);

}
