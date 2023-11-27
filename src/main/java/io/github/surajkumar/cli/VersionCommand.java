package io.github.surajkumar.cli;

public class VersionCommand implements Command {
    public VersionCommand() {}

    public void handle(String arg) {
        System.out.println("Timer version 1.0");
    }
}
