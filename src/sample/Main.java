package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import naoppy.othello.OthelloField;
import naoppy.othello.OthelloPlayer;

import java.util.function.Consumer;

public class Main extends Application {

    private OthelloField othelloField = new OthelloField();

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane root = new GridPane();
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Image image = new Image(this.getClass().getResourceAsStream("../None.png"));
                ImageView imageView = new ImageView(image);
                int finalY = y, finalX = x;
                imageView.setOnMouseClicked(event -> {
                    othelloField.putNewKoma(finalY,finalX);
                });
                root.add(imageView, y, x);
            }
        }

        primaryStage.setTitle("Naoppy Othello");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
