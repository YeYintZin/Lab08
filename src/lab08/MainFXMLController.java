/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package lab08;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author 6289490
 */
public class MainFXMLController {
    private enum PenSize {
        SMALL(2),
        MEDIUM(4),
        LARGE (6);
        private final int radius;
        PenSize(int radius) {this.radius = radius;}
        public int getRadius() {
            return radius;}
    };  

    @FXML private RadioButton blackRadio;
    @FXML private ToggleGroup group1;
    @FXML private RadioButton redRadio;
    @FXML private RadioButton greenRadio;
    @FXML private RadioButton blueRadio;
    @FXML private RadioButton smallRadio;
    @FXML private ToggleGroup group2;
    @FXML private RadioButton mediumRadio;
    @FXML private RadioButton largeRadio;
    @FXML private Button undoButton;
    @FXML private Button clearButton;
    @FXML private Pane drawingAreaPane;

    private PenSize radius = PenSize.MEDIUM;
    private Paint brushColor = Color.BLACK;

    public void initialize() {
        blackRadio.setUserData(Color.BLACK);
        redRadio.setUserData(Color.RED);
        greenRadio.setUserData(Color.GREEN);
        blueRadio.setUserData(Color.BLUE);
        smallRadio.setUserData(2);
        mediumRadio.setUserData(4);
        largeRadio.setUserData(6);
    }    

    @FXML
    private Color colorRadioButtonSelected() {
        return (Color) group2.getSelectedToggle().getUserData();
    }

    @FXML
    private int sizeRadioButtonSelected() {
        return (int) group1.getSelectedToggle().getUserData();
    }

    @FXML
    private void undoButtonPressed() {
        drawingAreaPane.getChildren().remove(drawingAreaPane.getChildren().size() - 1);
    }

    @FXML
    private void clearButtonPressed() {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    private void drawingAreaMouseDragged(MouseEvent e) {
        Circle circle = new Circle();
        circle.setLayoutX(e.getX());
        circle.setLayoutY(e.getY());
        circle.setRadius(sizeRadioButtonSelected());
        circle.setFill(colorRadioButtonSelected());
        drawingAreaPane.getChildren().add(circle);
    }
    
}
