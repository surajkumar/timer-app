package io.github.surajkumar.ui;

import io.github.surajkumar.time.TimeChangeEvent;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeChangeObserver implements TimeChangeEvent {
    private static final ScheduledExecutorService EXECUTOR_SERVICE = Executors.newScheduledThreadPool(1);
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("00");
    private final TimerPanel timerOverlay;

    public TimeChangeObserver(TimerPanel timerOverlay) {
        this.timerOverlay = timerOverlay;
    }

    @Override
    public void onChange(long time) {
        long minutes = time / 60;
        long seconds = time % 60;
        SwingUtilities.invokeLater(() -> {
            timerOverlay.setTime(DECIMAL_FORMAT.format(minutes) + ":" + DECIMAL_FORMAT.format(seconds));
            timerOverlay.revalidate();
            timerOverlay.repaint();
        });
    }

    @Override
    public void onFinish() {
        SwingUtilities.invokeLater(() ->
                timerOverlay.setTime("Finished"));
        EXECUTOR_SERVICE.schedule(this::exitApplication, 5, TimeUnit.SECONDS);
    }

    private void exitApplication() {
        System.exit(0);
    }
}
