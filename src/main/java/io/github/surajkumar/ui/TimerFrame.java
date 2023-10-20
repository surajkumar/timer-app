package io.github.surajkumar.ui;

import javax.swing.*;
import java.awt.*;

public class TimerFrame {
    private final JFrame frame;

    public TimerFrame(TimerPanel overlay, int overlayWidth, int overlayHeight) {
        frame = createFrame(overlayWidth, overlayHeight);
        frame.add(overlay.getPanel());
    }

    private JFrame createFrame(int overlayWidth, int overlayHeight) {
        Rectangle size = ScreenLocator.getDimensions(ScreenLocator.getCurrentTerminalScreen());
        JFrame frame = new JFrame(ScreenLocator.getCurrentTerminalScreen().getDefaultConfiguration());
        frame.setUndecorated(true);
        frame.setBackground(new Color(0, 0, 0, 0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(overlayWidth, overlayHeight);
        frame.setLocation(size.width - overlayWidth, overlayHeight);
        frame.setAlwaysOnTop(true);
        return frame;
    }

    public void show() {
        frame.setVisible(true);
    }
}
