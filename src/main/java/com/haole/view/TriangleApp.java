
package com.haole.view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class TriangleApp {
    private TextField side1Field = new TextField();
    private TextField side2Field = new TextField();
    private TextField side3Field = new TextField();
    private ComboBox<String> colorBox = new ComboBox<>();
    private CheckBox filledCheckBox = new CheckBox("Filled");
    private Button calculateBtn = new Button("Calculate");
    private TextArea outputArea = new TextArea();
    private VBox root;

    public TriangleApp() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        grid.add(new Label("Side 1:"), 0, 0);
        grid.add(side1Field, 1, 0);
        grid.add(new Label("Side 2:"), 0, 1);
        grid.add(side2Field, 1, 1);
        grid.add(new Label("Side 3:"), 0, 2);
        grid.add(side3Field, 1, 2);
        grid.add(new Label("Color:"), 0, 3);
        colorBox.getItems().addAll("Red", "Green", "Blue");
        grid.add(colorBox, 1, 3);
        grid.add(filledCheckBox, 1, 4);
        grid.add(calculateBtn, 1, 5);

        outputArea.setEditable(false);
        root = new VBox(10, grid, outputArea);
        root.setPadding(new Insets(10));
    }

    public VBox getRoot() { return root; }

    public double getSide1() { return Double.parseDouble(side1Field.getText()); }
    public double getSide2() { return Double.parseDouble(side2Field.getText()); }
    public double getSide3() { return Double.parseDouble(side3Field.getText()); }

    public String getColor() { return colorBox.getValue(); }
    public boolean isFilled() { return filledCheckBox.isSelected(); }

    public Button getCalculateButton() { return calculateBtn; }

    public void displayResult(String result) {
        outputArea.setText(result);
    }

    public void showLoading() {
        outputArea.setText("Calculating...");
    }

    public void displayError(String message) {
        outputArea.setText("Error: " + message);
    }
}
