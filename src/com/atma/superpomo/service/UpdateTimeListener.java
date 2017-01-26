package com.atma.superpomo.service;

import com.atma.superpomo.model.TimerType;
import com.atma.superpomo.service.timers.PomoTimer;

import java.util.TimerTask;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public interface UpdateTimeListener {

    public void updateTime(PomoTimer pomoTimer);

}
