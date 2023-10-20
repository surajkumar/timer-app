package io.github.surajkumar;

import io.github.surajkumar.time.TimerEventHandler;
import io.github.surajkumar.ui.TimeChangeObserver;
import io.github.surajkumar.ui.TimerPanel;
import io.github.surajkumar.ui.TimerFrame;

import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class TimerApplication {
    private static final ScheduledExecutorService EXECUTOR_SERVICE = Executors.newScheduledThreadPool(1);
    public static void main(String[] args) throws Exception {
        CommandLineParser parser = new CommandLineParser();
        TimerConfiguration config = parser.parse(args);
        if(config != null) {
            TimerPanel timerOverlay = new TimerPanel( 80, Color.DARK_GRAY);
            TimerFrame window = new TimerFrame(timerOverlay, 400, 100);
            EXECUTOR_SERVICE.submit(new TimerEventHandler(config, new TimeChangeObserver(timerOverlay)));
            window.show();
        }
    }
}
