package com.atma.superpomo.service;

import com.atma.superpomo.model.Pomodoro;
import com.atma.superpomo.service.tasks.MinutePomoTask;
import com.atma.superpomo.service.tasks.SecondPomoTask;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public class PomodoroService {

    public static void main(String[] args) {

        Pomodoro p = new Pomodoro();
        p.setPomoClock(new Date());

        SecondPomoTask st = new SecondPomoTask(p);
        st.start();

        while (!p.isFinished()) {
            System.out.println("Date: "+new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(p.getPomoClock()));
        }


    }

}
