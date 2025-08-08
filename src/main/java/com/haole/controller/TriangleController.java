package com.haole.controller;

import com.haole.model.Triangle;
import com.haole.util.TriangleTask;
import com.haole.view.TriangleApp;
import javafx.application.Platform;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

public class TriangleController {
    TriangleApp triangleApp;

    public TriangleController(TriangleApp triangleApp) {
        this.triangleApp = triangleApp;
    }

    public void handleCalculate() {
        try {
            double side1 = triangleApp.getSide1();
            double side2 = triangleApp.getSide2();
            double side3 = triangleApp.getSide3();
            String color = triangleApp.getColor();
            boolean filled = triangleApp.isFilled();

            Triangle triangle = new Triangle(side1, side2, side3);
            triangle.setColor(color);
            triangle.setFilled(filled);

            TriangleTask triangleTask = new TriangleTask(triangle);

            triangleApp.showLoading();

            triangleTask.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    String result = triangleTask.getValue();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            triangleApp.displayResult(result);
                        }
                    });
                }
            });

            triangleTask.setOnFailed(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            triangleApp.displayError(triangleTask.getException().getMessage());
                        }
                    });
                }
            });

            new Thread(triangleTask).start();
        } catch (Exception e) {
            triangleApp.displayError("Invalid input: " + e.getMessage());
        }
    }
}
