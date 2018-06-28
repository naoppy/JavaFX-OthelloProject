package naoppy.othello;

public class OthelloField {

    private final Koma[][] fieldMap = new Koma[8][8];

    private boolean nextIsWhite = true;

    public OthelloField() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                fieldMap[y][x] = Koma.NONE;
            }
        }
        fieldMap[3][3] = fieldMap[4][4] = Koma.WHITE;
        fieldMap[3][4] = fieldMap[4][3] = Koma.BLACK;
    }

    /**
     * 文字列表現を返します、実質的にフィールドを表示している
     * @return fieldMapの文字列表現
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
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
            if (y != 7) sb.append('\n');
        }

        return sb.toString();
    }

    static int[] lookingWayX = {1, 0, -1, 0};
    static int[] lookingWayY = {0, 1, 0, -1};

    /**
     * 新しく駒を置きます.
     * @param y 新しく駒を置くy座標(0-indexed)
     * @param x 新しく駒を置くx座標(0-indexed)
     * @return オセロのルールに従って置くことに成功したか
     */
    public boolean putNewKoma(int y, int x) {
        //既にある場所に重ねて置けない
        if (fieldMap[y][x] != Koma.NONE) return false;

        boolean isUpdated = false;
        Koma puttingPlayerKoma = getNextIsWhite() ? Koma.WHITE : Koma.BLACK;
        Koma enemyPlayerKoma = getNextIsWhite() ? Koma.BLACK : Koma.WHITE;

        for (int i = 0; i < 4; i++) {
            int lookingY = y, lookingX = x;
            lookingY += lookingWayY[i];
            lookingX += lookingWayX[i];
            if (fieldMap[lookingY][lookingX] == enemyPlayerKoma) {
                while (fieldMap[lookingY][lookingX] == enemyPlayerKoma) {
                    lookingY += lookingWayY[i];
                    lookingX += lookingWayX[i];
                }
                if (fieldMap[lookingY][lookingX] == puttingPlayerKoma) {
                    isUpdated |= true;
                    while (!(lookingY == y && lookingX == x)) {
                        fieldMap[lookingY][lookingX] = puttingPlayerKoma;
                        lookingY -= lookingWayY[i];
                        lookingX -= lookingWayX[i];
                    }
                    fieldMap[y][x] = puttingPlayerKoma;
                }
            }
        }
        if (isUpdated) this.nextIsWhite = !this.nextIsWhite;

        return isUpdated;
    }

    public boolean getNextIsWhite() {
        return this.nextIsWhite;
    }

    public void setNextIsWhite(boolean nextIsWhite) {
        this.nextIsWhite = nextIsWhite;
    }
}
