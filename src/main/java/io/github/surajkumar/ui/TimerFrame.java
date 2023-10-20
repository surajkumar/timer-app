package io.github.surajkumar.ui;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class TimerFrame {
    private final JFrame frame;

    public TimerFrame(TimerPanel overlay, int overlayWidth, int overlayHeight) throws Exception {
        this.frame = createFrame(overlay, overlayWidth, overlayHeight);
    }

    private JFrame createFrame(TimerPanel overlay, int overlayWidth, int overlayHeight) throws Exception {
        JFrame jframe = new JFrame(ScreenLocator.getCurrentTerminalScreen().getDefaultConfiguration());
        SwingUtilities.invokeAndWait(() -> {
            Rectangle size = ScreenLocator.getDimensions(ScreenLocator.getCurrentTerminalScreen());
            jframe.setUndecorated(true);
            jframe.setBackground(new Color(0, 0, 0, 0));
            jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jframe.setSize(overlayWidth, overlayHeight);
            jframe.setLocation(size.width - overlayWidth, overlayHeight);
            jframe.setContentPane(overlay);
            jframe.setAlwaysOnTop(true);
        });
        return jframe;
    }

    public void show() {
        frame.setVisible(true);
    }
}
