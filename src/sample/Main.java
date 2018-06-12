package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    private Button reactionButton;
    private Rectangle rectangle;
    private Label label;
    public static volatile long startTime;

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane grid = new GridPane();
        buildGridPane(grid);
        reactionButton = new Button("Click when you see red!");
        buildReactionButton(reactionButton);
        rectangle = new Rectangle();
        buildRectangle(rectangle);
        label = new Label();
        GridPane.setConstraints(label, 2, 6);
        grid.getChildren().addAll(reactionButton, rectangle, label);
        primaryStage.setTitle("Reaction Time Checker");
        primaryStage.setScene(new Scene(grid, 480, 320));
        new ChangeColorGenerator(rectangle).start();
        primaryStage.show();
    }



    private void buildRectangle(Rectangle rectangle) {
        rectangle.setX(50);
        rectangle.setY(50);
        rectangle.setWidth(200);
        rectangle.setHeight(100);
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);
        GridPane.setConstraints(rectangle, 3, 5);
    }


    private void buildReactionButton(Button reactionButton) {
        reactionButton.setOnAction(
                e -> {
                    if(rectangle.getFill().equals(Color.RED)) {
                        label.setText("Your score is: " + (System.currentTimeMillis() - startTime) + " milis");
                        new ChangeColorGenerator(rectangle).start();
                    } else {
                        label.setText("Wait for red color!");
                    }
                });
        reactionButton.setPrefWidth(200);
        reactionButton.setPrefHeight(100);
        GridPane.setConstraints(reactionButton, 2, 5);
    }

    private void buildGridPane(GridPane grid) {
        grid.setHgap(15);
        grid.setPadding(new Insets(0, 0, 0, 0));
        grid.setVgap(15);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
