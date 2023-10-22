package io.github.surajkumar.cli;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandLineParser {
    private static final Pattern PATTERN = Pattern.compile("([0-9]+)([a-zA-Z]+)");
    private static final Map<String, String> UNIT_CONVERSIONS = new HashMap<>();
    static {
        UNIT_CONVERSIONS.put("s", "SECONDS");
        UNIT_CONVERSIONS.put("ms", "MILLISECONDS");
        UNIT_CONVERSIONS.put("m", "MINUTES");
        UNIT_CONVERSIONS.put("h", "HOURS");
    }

    public boolean parseAndRunCommands(String[] args) {
        int count = 0;
        if (args.length != 0) {
            for (int i = 0; i < args.length; ++i) {
                String s = args[i];
                String command = s.substring(2);
                String arg = "";
                if (s.startsWith("--")) {
                    if (i < args.length - 1 && !args[i + 1].startsWith("--")) {
                        command = s.substring(2);
                        arg = args[i + 1];
                        i += 2;
                    }
                    if(CommandHandler.handle(command, arg)) {
                        count++;
                    }
                }
            }
        }
        return count > 0;
    }

    public TimerConfiguration parse(String[] args) {
        if (args.length != 0) {
            Matcher matcher = PATTERN.matcher(args[0]);
            if (matcher.find()) {
                String unit = matcher.group(2);
                if (this.isCorrectUnit(unit)) {
                    TimeUnit timeUnit = TimeUnit.valueOf(UNIT_CONVERSIONS.get(unit.toLowerCase()));
                    return new TimerConfiguration(Integer.parseInt(matcher.group(1)), timeUnit);
                }
            }

        }
        return null;
    }

    private boolean isCorrectUnit(String arg) {
        return arg != null && UNIT_CONVERSIONS.containsKey(arg.toLowerCase());
    }
}
