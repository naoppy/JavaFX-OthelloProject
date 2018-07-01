package naoppy.othello.core;

import naoppy.othello.core.Koma;

public class OthelloField {

    /**
     * 8*8の盤面の周りを1マスの壁で囲ったフィールドです
     */
    private final Koma[][] fieldMap = new Koma[10][10];
    /**
     * 次に置かれる駒が白なのかを保持します
     */
    private boolean nextIsWhite = true;

    public OthelloField() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                fieldMap[y][x] = (y == 0 || y == 9 || x == 0 || x == 9) ? Koma.WALL : Koma.NONE;
            }
        }
        fieldMap[4][4] = fieldMap[5][5] = Koma.WHITE;
        fieldMap[4][5] = fieldMap[5][4] = Koma.BLACK;
    }

    /**
     * 文字列表現を返します、実質的にフィールドを表示している
     *
     * @return fieldMapの文字列表現
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 1; y < 9; y++) {
            for (int x = 1; x < 9; x++) {
                switch (fieldMap[y][x]) {
                    case NONE:
                        sb.append(' ');
                        break;
                    case BLACK:
                        sb.append('x');
                        break;
                    case WHITE:
                        sb.append('o');
                        break;
                }
            }
            if (y != 8) sb.append('\n');
        }

        return sb.toString();
    }

    private static int[] lookingWayX = {1, 0, -1, 0, 1, -1, -1, 1};
    private static int[] lookingWayY = {0, 1, 0, -1, 1, 1, -1, -1};

    /**
     * 新しく駒を置きます.
     *
     * @param y 新しく駒を置くy座標(0-indexed)、0～7の間で指定する
     * @param x 新しく駒を置くx座標(0-indexed)、0～7の間で指定する
     * @return オセロのルールに従って置くことに成功したか
     */
    public boolean putNewKoma(int y, int x) {
        //範囲外の場合
        if (x < 0 || y < 0 || x > 7 || y > 7) {
            return false;
        }
        //1-indexedに変換
        y++;
        x++;
        //既にある場所に重ねて置けない
        if (fieldMap[y][x] != Koma.NONE) return false;

        boolean isUpdated = false;
        Koma puttingPlayerKoma = getNextIsWhite() ? Koma.WHITE : Koma.BLACK;
        Koma enemyPlayerKoma = getNextIsWhite() ? Koma.BLACK : Koma.WHITE;

        for (int i = 0; i < 8; i++) {
            int lookingY = y, lookingX = x;
            lookingY += lookingWayY[i];
            lookingX += lookingWayX[i];
            if (fieldMap[lookingY][lookingX] == enemyPlayerKoma) {//敵の駒なら、敵の駒が続くまで移動
                while (fieldMap[lookingY][lookingX] == enemyPlayerKoma) {
                    lookingY += lookingWayY[i];
                    lookingX += lookingWayX[i];
                }
                if (fieldMap[lookingY][lookingX] == puttingPlayerKoma) {//最後が自分の駒で終わっているか
                    isUpdated = true;
                    while (!(lookingY == y && lookingX == x)) {//その間を自分の駒にしていく
                        fieldMap[lookingY][lookingX] = puttingPlayerKoma;
                        lookingY -= lookingWayY[i];
                        lookingX -= lookingWayX[i];
                    }
                    fieldMap[y][x] = puttingPlayerKoma;
                }
            }
        }
        //敵のターンに
        if (isUpdated) this.setNextIsWhite(!this.getNextIsWhite());

        return isUpdated;
    }

    public Koma[][] getFieldMap() {
        return fieldMap;
    }

    public boolean getNextIsWhite() {
        return this.nextIsWhite;
    }

    public void setNextIsWhite(boolean nextIsWhite) {
        this.nextIsWhite = nextIsWhite;
    }
}
