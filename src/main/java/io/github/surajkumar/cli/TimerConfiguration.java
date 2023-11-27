package io.github.surajkumar.cli;

import java.util.concurrent.TimeUnit;

public record TimerConfiguration(int time, TimeUnit timeUnit) {
}
