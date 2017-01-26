package com.atma.superpomo.service;

import com.atma.superpomo.service.tasks.MinutePomoTask;
import com.atma.superpomo.service.tasks.SecondPomoTask;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public class PomodoroService {

    public static void main(String[] args) {

        SecondPomoTask st = new SecondPomoTask();
        st.start();

        MinutePomoTask mt = new MinutePomoTask();
        mt.start();

    }

}
