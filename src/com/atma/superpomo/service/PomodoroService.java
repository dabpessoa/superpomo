package com.atma.superpomo.service;

import com.atma.superpomo.model.Pomodoro;
import com.atma.superpomo.service.tasks.SecondPomoTask;
import com.atma.superpomo.service.timer.PomoTimerTask;
import com.atma.superpomo.service.timer.PomoTimerTaskListener;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public class PomodoroService implements PomoTimerTaskListener {

    public static void main(String[] args) {

        Pomodoro p = new Pomodoro();
        p.setPomoClock(new Date());

        SecondPomoTask st = new SecondPomoTask(p);
        st.addPomoTimerTaskListener(new PomodoroService());
        st.start();

    }

    @Override
    public void taskExecuted(PomoTimerTask pomoTimerTask) {
        System.out.println("Time: "+new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(pomoTimerTask.getPomodoro().getPomoClock()));
    }
}
