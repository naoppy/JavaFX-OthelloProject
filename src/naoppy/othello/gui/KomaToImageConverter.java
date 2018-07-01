package naoppy.othello.gui;

import javafx.scene.image.Image;
import naoppy.othello.core.Koma;

import java.util.HashMap;
import java.util.Map;

/**
 * 盤面と表示を紐づけるクラス
 */
public class KomaToImageConverter {
    private static Map<Koma, Image> convertMap = new HashMap<>();

    private KomaToImageConverter(){}

    public static Image convert(Koma koma) {
        if(!convertMap.containsKey(Koma.NONE)) convertMap.put(Koma.NONE, new Image(KomaToImageConverter.class.getClassLoader().getResourceAsStream("None.png")));
        if(!convertMap.containsKey(Koma.WHITE)) convertMap.put(Koma.WHITE, new Image(KomaToImageConverter.class.getClassLoader().getResourceAsStream("White.png")));
        if(!convertMap.containsKey(Koma.BLACK)) convertMap.put(Koma.BLACK, new Image(KomaToImageConverter.class.getClassLoader().getResourceAsStream("Black.png")));

        return convertMap.get(koma);
    }
}
