package View;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage; 
import model.Triangle;
import model.TriangleException;

public class TriangleApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // STEP 5: GUI Components
        TextField side1Field = new TextField();
        TextField side2Field = new TextField();
        TextField side3Field = new TextField();
        ComboBox<String> colorBox = new ComboBox<>();
        colorBox.getItems().addAll("Red", "Green", "Blue");
        CheckBox filledCheckBox = new CheckBox("Filled");
        Button calculateBtn = new Button("Calculate");
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);

        // Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Side 1:"), 0, 0);
        grid.add(side1Field, 1, 0);
        grid.add(new Label("Side 2:"), 0, 1);
        grid.add(side2Field, 1, 1);
        grid.add(new Label("Side 3:"), 0, 2);
        grid.add(side3Field, 1, 2);
        grid.add(new Label("Color:"), 0, 3);
        grid.add(colorBox, 1, 3);
        grid.add(filledCheckBox, 1, 4);
        grid.add(calculateBtn, 1, 5);

        VBox root = new VBox(10, grid, outputArea);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 350, 350);
        primaryStage.setTitle("Triangle Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();

        // STEP 6: Multi threaded Action Handling
        calculateBtn.setOnAction(e -> {
            Task<Void> task = new Task<>() {
                @Override
                protected Void call() {
                    try {
                        double s1 = Double.parseDouble(side1Field.getText());
                        double s2 = Double.parseDouble(side2Field.getText());
                        double s3 = Double.parseDouble(side3Field.getText());
                        String color = colorBox.getValue();
                        boolean filled = filledCheckBox.isSelected();

                        Triangle triangle = new Triangle(s1, s2, s3);
                        triangle.setColor(color);
                        triangle.setFilled(filled);

                        double area = triangle.getArea();
                        double perimeter = triangle.getPerimeter();

                        Platform.runLater(() -> {
                            outputArea.setText("Area: " + area +
                                    "\nPerimeter: " + perimeter +
                                    "\nColor: " + triangle.getColor() +
                                    "\nFilled: " + triangle.isFilled());
                        });
                    } catch (TriangleException ex) {
                        Platform.runLater(() -> showAlert("Invalid Triangle", ex.getMessage()));
                    } catch (Exception ex) {
                        Platform.runLater(() -> showAlert("Input Error", "Please enter valid numbers."));
                    }
                    return null;
                }
            };
            new Thread(task).start();
        });
    }

    // STEP 7: Alert Helper Method
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
