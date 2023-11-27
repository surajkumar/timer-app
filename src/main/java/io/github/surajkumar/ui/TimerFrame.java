package io.github.surajkumar.ui;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TimerFrame extends Application {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 200;

    private static final Text TIME = new Text("Hello");

    static {
        TIME.setFont(new Font("Arial", 80));
        TIME.setFill(Color.DARKGRAY);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        root.getChildren().add(TIME);
        Scene scene = new Scene(root, Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX(bounds.getMaxX() - WIDTH);
        primaryStage.setY(0);
        primaryStage.show();
    }

    public static Text getTimeText() {
        return TIME;
    }
}
