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
        boolean ranCommands = parser.parseAndRunCommands(args);
        TimerConfiguration config = parser.parse(args);
        if (config != null) {
            EXECUTOR_SERVICE.submit(new TimerEventHandler(config, new TimeChangeObserver(TimerFrame.getTimeText())));
            Application.launch(TimerFrame.class);
        } else if(!ranCommands) {
            printUsage();
        }
    }

    private static void printUsage() {
        System.out.println("Usage: timer <time><unit> - Start a timer with the specified time and unit.");
        System.out.println("Available time units:");
        System.out.println("- ms (milliseconds)");
        System.out.println("- s  (seconds)");
        System.out.println("- m  (minutes)");
        System.out.println("- h  (hours)");
        System.out.println("Example: timer 10s");
    }
}
