package io.github.surajkumar.ui;

import io.github.surajkumar.sound.SoundPlayer;
import io.github.surajkumar.time.TimeChangeEvent;

import javafx.scene.text.Text;

import java.text.DecimalFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeChangeObserver implements TimeChangeEvent {
    private static final ScheduledExecutorService EXECUTOR_SERVICE =
            Executors.newScheduledThreadPool(1);
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("00");
    private final Text text;

    public TimeChangeObserver(Text text) {
        this.text = text;
    }

    @Override
    public void onChange(long time) {
        long minutes = time / 60;
        long seconds = time % 60;
        text.setText(DECIMAL_FORMAT.format(minutes) + ":" + DECIMAL_FORMAT.format(seconds));
    }

    @Override
    public void onFinish() {
        SoundPlayer.playSound();
        text.setText("Finished");
        EXECUTOR_SERVICE.schedule(this::exitApplication, 5, TimeUnit.SECONDS);
    }

    private void exitApplication() {
        System.exit(0);
    }
}
