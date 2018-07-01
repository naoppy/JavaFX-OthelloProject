package naoppy.othello.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import naoppy.othello.core.OthelloField;

public class Main extends Application {

    /**
     * オセロの盤面
     */
    private OthelloField othelloField = new OthelloField();
    /**
     * オセロの盤面を表示するViewer
     */
    private Viewer viewer = new Viewer(othelloField);

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Naoppy Othello");
        primaryStage.setScene(new Scene(viewer.getView()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
