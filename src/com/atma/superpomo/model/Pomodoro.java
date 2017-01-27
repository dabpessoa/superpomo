package com.atma.superpomo.model;

import com.atma.superpomo.model.enums.TimerType;
import com.atma.superpomo.util.DateUtils;

import java.util.Date;

/**
 * Created by diego.pessoa on 25/01/2017.
 */
public class Pomodoro {

    private Date durationTaskTime;
    private Date intervalTime;
    private Date bigIntervalTime;
    private Date pomoClock;

    private Integer taskSizeBeforeBigInterval;

    private boolean isBigInterval;
    private boolean isInterval;

    public Pomodoro() {}

    public boolean isFinished() {
        return DateUtils.isZeroTime(getPomoClock());
    }

    public void updatePomoClockTime(TimerType timerType, int amount) {
        switch (timerType) {
            case SECOND: {
                setPomoClock(DateUtils.addSecond(getPomoClock(), amount));
                break;
            }
            case MINUTE: {
                setPomoClock(DateUtils.addMinute(getPomoClock(), amount));
                break;
            }
            case HOUR: {
                setPomoClock(DateUtils.addHour(getPomoClock(), amount));
                break;
            }
        }
    }

    public Date getDurationTaskTime() {
        return durationTaskTime;
    }

    public void setDurationTaskTime(Date durationTaskTime) {
        this.durationTaskTime = durationTaskTime;
    }

    public Date getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(Date intervalTime) {
        this.intervalTime = intervalTime;
    }

    public Date getBigIntervalTime() {
        return bigIntervalTime;
    }

    public void setBigIntervalTime(Date bigIntervalTime) {
        this.bigIntervalTime = bigIntervalTime;
    }

    public Integer getTaskSizeBeforeBigInterval() {
        return taskSizeBeforeBigInterval;
    }

    public void setTaskSizeBeforeBigInterval(Integer taskSizeBeforeBigInterval) {
        this.taskSizeBeforeBigInterval = taskSizeBeforeBigInterval;
    }

    public boolean isBigInterval() {
        return isBigInterval;
    }

    public void setBigInterval(boolean bigInterval) {
        isBigInterval = bigInterval;
    }

    public boolean isInterval() {
        return isInterval;
    }

    public void setInterval(boolean interval) {
        isInterval = interval;
    }

    public Date getPomoClock() {
        return pomoClock;
    }

    public void setPomoClock(Date pomoClock) {
        this.pomoClock = pomoClock;
    }

}
