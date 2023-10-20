package io.github.surajkumar;

import io.github.surajkumar.cli.CommandLineParser;
import io.github.surajkumar.cli.TimerConfiguration;
import io.github.surajkumar.time.TimerEventHandler;
import io.github.surajkumar.ui.TimeChangeObserver;
import io.github.surajkumar.ui.TimerFrame;
import javafx.application.Application;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class TimerApplication {
    private static final ScheduledExecutorService EXECUTOR_SERVICE = Executors.newScheduledThreadPool(1);
    public static void main(String[] args) {
        CommandLineParser parser = new CommandLineParser();
        TimerConfiguration config = parser.parse(args);
        if(config != null) {
            EXECUTOR_SERVICE.submit(new TimerEventHandler(config, new TimeChangeObserver(TimerFrame.getTimeText())));
            Application.launch(TimerFrame.class);
        }
    }
}
