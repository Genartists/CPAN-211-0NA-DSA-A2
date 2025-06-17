package com.haole;

import com.haole.controller.TriangleController;
import com.haole.view.TriangleApp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        TriangleApp view = new TriangleApp();
        TriangleController controller = new TriangleController(view);

        view.getCalculateButton().setOnAction(e -> controller.handleCalculate());

        Scene scene = new Scene(view.getRoot(), 350, 350);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Triangle Calculator");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
