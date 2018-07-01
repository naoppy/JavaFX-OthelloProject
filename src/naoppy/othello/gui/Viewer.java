package naoppy.othello.gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import naoppy.othello.core.Koma;
import naoppy.othello.core.OthelloField;

/**
 * オセロ盤を表示するためのクラス
 */
public class Viewer {
    /**
     * 表示の為のコンポーネント
     */
    private GridPane view = new GridPane();
    /**
     * 表示の為のソース
     */
    private Koma[][] map;

    /**
     * Viewerを生成する
     *
     * @param field 表示の為のソース
     */
    public Viewer(OthelloField field) {
        map = field.getFieldMap();

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                ImageView imageView = new ImageView();
                final int Y = y, X = x;
                imageView.setOnMouseClicked(event -> {
                    field.putNewKoma(Y, X);
                    update();
                });
                view.add(imageView, y, x);
            }
        }

        update();
    }

    public GridPane getView() {
        return view;
    }

    /**
     * Viewerの表示を更新する
     */
    public void update() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                ImageView imageView = (ImageView) view.getChildren().get(8 * y + x);
                //画像の選択は別クラスに移譲
                Image rightImage = KomaToImageConverter.convert(map[y + 1][x + 1]);

                if (!rightImage.equals(imageView.getImage())) {
                    imageView.setImage(rightImage);
                }
            }
        }
    }
}
