package io.github.surajkumar.cli;

import java.util.concurrent.TimeUnit;

public class TimerConfiguration {
    private final int time;
    private final TimeUnit timeUnit;
    
    public TimerConfiguration(int time, TimeUnit timeUnit) {
        this.time = time;
        this.timeUnit = timeUnit;
    }

    public int getTime() {
        return time;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }
}
