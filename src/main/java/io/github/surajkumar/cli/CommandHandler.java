package io.github.surajkumar.cli;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler {
    private static final Map<String, Command> COMMANDS = new HashMap<>();
    static {
        COMMANDS.put("version", new VersionCommand());
    }

    public static boolean handle(String command, String argument) {
        if (COMMANDS.containsKey(command.toLowerCase())) {
            COMMANDS.get(command).handle(argument);
            return true;
        }
        return false;
    }
}
