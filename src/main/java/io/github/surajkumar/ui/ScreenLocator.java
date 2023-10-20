package io.github.surajkumar.ui;

import java.awt.*;

public class ScreenLocator {

    private ScreenLocator() {}

    public static GraphicsDevice getCurrentTerminalScreen() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] screens = ge.getScreenDevices();
        GraphicsDevice terminalScreen = null;
        for (GraphicsDevice screen : screens) {
            Rectangle screenBounds = screen.getDefaultConfiguration().getBounds();
            if (screenBounds.contains(MouseInfo.getPointerInfo().getLocation())) {
                terminalScreen = screen;
                break;
            }
        }
        return terminalScreen;
    }

    public static Rectangle getDimensions(GraphicsDevice terminalScreen) {
        return terminalScreen.getDefaultConfiguration().getBounds();
    }
}
