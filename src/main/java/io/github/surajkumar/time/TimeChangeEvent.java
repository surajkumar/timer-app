package io.github.surajkumar.time;

public interface TimeChangeEvent {
    void onChange(long time);
    void onFinish();
}
