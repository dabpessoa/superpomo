package com.atma.superpomo.service;

import com.atma.superpomo.model.Pomodoro;
import com.atma.superpomo.model.enums.TimerType;
import com.atma.superpomo.service.tasks.MinutePomoTask;
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

        MinutePomoTask mt = new MinutePomoTask(p);
        mt.addPomoTimerTaskListener(new PomodoroService());

        st.start();
        mt.start();

    }

    @Override
    public void taskExecuted(PomoTimerTask pomoTimerTask) {
        if (pomoTimerTask.getPomoTimer().getTimerType() == TimerType.SECOND) {
            System.out.println("SECOND Time: "+new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(pomoTimerTask.getPomodoro().getPomoClock()));
        } else if (pomoTimerTask.getPomoTimer().getTimerType() == TimerType.MINUTE) {
            System.out.println("MINUTE Time: "+new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(pomoTimerTask.getPomodoro().getPomoClock()));
        }
    }
}
