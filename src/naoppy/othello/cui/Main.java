package naoppy.othello.cui;

import naoppy.othello.SimpleReadFromGeneralInput;
import naoppy.othello.cui.CUIOthello;

public class Main {
    public static void main(String[] args) {
        CUIOthello game = new CUIOthello(new SimpleReadFromGeneralInput(), new SimpleReadFromGeneralInput());
        game.run();
    }
}
