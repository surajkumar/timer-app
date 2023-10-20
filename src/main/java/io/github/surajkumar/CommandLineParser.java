package io.github.surajkumar;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandLineParser {
    private static final Map<String, String> UNIT_CONVERSIONS = new HashMap<>();
    static {
        UNIT_CONVERSIONS.put("s", "SECONDS");
        UNIT_CONVERSIONS.put("ms", "MILLISECONDS");
        UNIT_CONVERSIONS.put("m", "MINUTES");
        UNIT_CONVERSIONS.put("h", "HOURS");
    }

    private static final Pattern PATTERN = Pattern.compile("([0-9]+)([a-zA-Z]+)");

    public TimerConfiguration parse(String[] args) {
        if (args.length == 0) {
            printUsage();
            return null;
        }
        Matcher matcher = PATTERN.matcher(args[0]);
        if (matcher.find()) {
            String unit = matcher.group(2);
            if (isCorrectUnit(unit)) {
                TimeUnit timeUnit = TimeUnit.valueOf(UNIT_CONVERSIONS.get(unit.toLowerCase()));
                return new TimerConfiguration(Integer.parseInt(matcher.group(1)), timeUnit);
            } else {
                printError("Unknown time unit: " + unit);
                printUsage();
            }
        } else {
            printError("Invalid input format. Please use the following format: <time><unit>, for example, 10s.");
        }
        return null;
    }

    private boolean isCorrectUnit(String arg) {
        return arg != null && UNIT_CONVERSIONS.containsKey(arg.toLowerCase());
    }

    private void printError(String message) {
        System.err.println(message);
    }

    private void printUsage() {
        System.out.println("Usage: timer <time><unit> - Start a timer with the specified time and unit.");
        System.out.println("Available time units:");
        System.out.println("- ms (milliseconds)");
        System.out.println("- s  (seconds)");
        System.out.println("- m  (minutes)");
        System.out.println("- h  (hours)");
        System.out.println("Example: timer 10s");
    }
}
