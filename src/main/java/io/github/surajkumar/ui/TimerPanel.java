package io.github.surajkumar.ui;

import javax.swing.*;
import java.awt.*;

public class TimerPanel {
    private final JPanel panel;
    private final JLabel timerLabel;

    public TimerPanel(int fontSize, Color textColor) {
        this.panel = createPanel();
        this.timerLabel = createTimerLabel(fontSize, textColor);
        panel.add(timerLabel);
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0, 0));
        return panel;
    }

    private JLabel createTimerLabel(int fontSize, Color textColor) {
        JLabel timerLabel = new JLabel();
        timerLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
        timerLabel.setForeground(textColor);
        return timerLabel;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JLabel getTimerLabel() {
        return timerLabel;
    }
}
