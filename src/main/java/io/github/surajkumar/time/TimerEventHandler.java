package io.github.surajkumar.time;

import io.github.surajkumar.cli.TimerConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimerEventHandler implements Runnable {
    private final Timer timer;
    private final TimerConfiguration configuration;
    private final List<TimeChangeEvent> timeChangeObservers;

    public TimerEventHandler(TimerConfiguration configuration, TimeChangeEvent... timeChangeEvents) {
        this.timer = new Timer();
        this.configuration = configuration;
        this.timeChangeObservers = Arrays.asList(timeChangeEvents);
    }

    @Override
    public void run() {
        timer.schedule(new TimerTask() {
            long timeLeft = TimeUnit.MILLISECONDS.convert(configuration.getTime(), configuration.getTimeUnit()) / 1000;

            @Override
            public void run() {
                if (timeLeft <= 0) {
                    timer.cancel();
                    timeChangeObservers.forEach(TimeChangeEvent::onFinish);
                } else {
                    timeChangeObservers.forEach(observer -> observer.onChange(timeLeft));
                    timeLeft--;
                }
            }
        }, 0, 1000);
    }
}
