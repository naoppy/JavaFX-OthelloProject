package naoppy.othello;

public class Main {
    public static void main(String[] args) {
        CUIOthello game = new CUIOthello(new SimpleReadFromGeneralInput(), new SimpleReadFromGeneralInput());
        game.run();
    }
}
