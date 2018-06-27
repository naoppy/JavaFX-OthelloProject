package naoppy.othello;

public class OthelloField {

    private final Koma[][] fieldMap = new Koma[8][8];

    private boolean nextIsWhite = true;

    public OthelloField() {
        for(int y = 0; y < 8; y++) {
            for(int x = 0; x < 8; x++) {
                fieldMap[y][x] = Koma.NONE;
            }
        }
        fieldMap[3][3] = fieldMap[4][4] = Koma.WHITE;
        fieldMap[3][4] = fieldMap[4][3] = Koma.BLACK;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int y = 0; y < 8; y++) {
            for(int x = 0; x < 8; x++) {
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
            if(y!=7) sb.append('\n');
        }

        return sb.toString();
    }

    public void putNewKoma(int y, int x) {

    }

    public boolean getIsNextIsWhite() {
        return this.nextIsWhite;
    }
}
