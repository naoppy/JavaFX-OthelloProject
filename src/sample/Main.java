package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        GridPane root = new GridPane();
        root.setGridLinesVisible(true);
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Group g = new Group();
                g.getChildren().add(new Rectangle(50, 50, Color.WHITE));
                root.add(g, y, x);
            }
        }

        primaryStage.setTitle("Naoppy Othello");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        System.err.println(root.isGridLinesVisible());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
