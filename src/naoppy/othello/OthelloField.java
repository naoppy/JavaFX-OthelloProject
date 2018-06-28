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
                }
            }
            if (y != 7) sb.append('\n');
        }

        return sb.toString();
    }

    static int[] lookingWayX = {1, 0, -1, 0};
    static int[] lookingWayY = {0, 1, 0, -1};

    public boolean putNewKoma(int y, int x) {
        boolean isUpdated = false;

        //既にある場所に重ねて置けない
        if (fieldMap[y][x] != Koma.NONE) return false;


        for (int i = 0; i < 4; i++) {
            int lookingY = y, lookingX = x;
            lookingY += lookingWayY[i];
            lookingX += lookingWayX[i];
            if (fieldMap[lookingY][lookingX] == Koma.BLACK && nextIsWhite) {
                while (fieldMap[lookingY][lookingX] == Koma.BLACK) {
                    lookingY += lookingWayY[i];
                    lookingX += lookingWayX[i];
                }
                if (fieldMap[lookingY][lookingX] == Koma.WHITE) {
                    isUpdated |= true;
                    while (!(lookingY == y && lookingX == x)) {
                        fieldMap[lookingY][lookingX] = Koma.WHITE;
                        lookingY -= lookingWayY[i];
                        lookingX -= lookingWayX[i];
                    }
                    fieldMap[y][x] = Koma.WHITE;
                }
            } else if (fieldMap[lookingY][lookingX] == Koma.WHITE && !nextIsWhite) {
                while (fieldMap[lookingY][lookingX] == Koma.WHITE) {
                    lookingY += lookingWayY[i];
                    lookingX += lookingWayX[i];
                }
                if (fieldMap[lookingY][lookingX] == Koma.BLACK) {
                    isUpdated |= true;
                    while (!(lookingY == y && lookingX == x)) {
                        fieldMap[lookingY][lookingX] = Koma.BLACK;
                        lookingY -= lookingWayY[i];
                        lookingX -= lookingWayX[i];
                    }
                    fieldMap[y][x] = Koma.BLACK;
                }
            }
        }
        if (isUpdated) {
            this.nextIsWhite = !this.nextIsWhite;
        }

        return isUpdated;
    }

    public boolean getNextIsWhite() {
        return this.nextIsWhite;
    }
}
