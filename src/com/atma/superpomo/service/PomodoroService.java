package com.atma.superpomo.service;

import com.atma.superpomo.service.timers.PomoTimer;
import com.atma.superpomo.service.timers.SecondTimer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public class PomodoroService implements UpdateTimeListener {

    public static void main(String[] args) {

        PomoTimerTask task = new PomoTimerTask() {
            @Override
            public void doJob() {
                System.out.println("foi..."+new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
            }
        };
        task.addTimeListener(new PomodoroService());

        SecondTimer st = new SecondTimer();
        st.start(task);


        git init
        git add README.md
        git commit -m "first commit"
        git remote add origin https://github.com/dabpessoa/superpomo.git
        git push -u origin master

    }

    @Override
    public void updateTime(PomoTimer pomoTimer) {
        System.out.println("terminou...");
    }
}
