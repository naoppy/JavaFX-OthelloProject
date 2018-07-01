package naoppy.othello.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import naoppy.othello.core.Koma;
import naoppy.othello.core.OthelloField;

public class Main extends Application {

    private OthelloField othelloField = new OthelloField();

    private GridPane viewer;

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane root = new GridPane();
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                ImageView imageView = new ImageView();
                int finalY = y, finalX = x;
                imageView.setOnMouseClicked(event -> {
                    othelloField.putNewKoma(finalY,finalX);
                    update();
                });
                root.add(imageView, finalY, finalX);
            }
        }
        viewer = root;
        update();

        primaryStage.setTitle("Naoppy Othello");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void update() {
        Koma[][] map = othelloField.getFieldMap();
        for(int y = 0; y < 8; y++) {
            for(int x = 0; x < 8; x++) {
                ImageView imageView = (ImageView)viewer.getChildren().get(8*y+x);
                imageView.setImage(selectImage(map[y+1][x+1]));
            }
        }
    }

    private Image selectImage(Koma koma) {
        Image image = null;
        switch (koma) {
            case NONE:
                image = new Image(this.getClass().getClassLoader().getResourceAsStream("None.png"));
                break;
            case WHITE:
                image = new Image(this.getClass().getClassLoader().getResourceAsStream("White.png"));
                break;
            case BLACK:
                image = new Image(this.getClass().getClassLoader().getResourceAsStream("Black.png"));
                break;
        }
        return image;
    }
}
