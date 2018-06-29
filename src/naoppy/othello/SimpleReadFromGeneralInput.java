package naoppy.othello;

import java.awt.*;
import java.util.Scanner;

public class SimpleReadFromGeneralInput implements OthelloPlayer {

    private Scanner sc = new Scanner(System.in);

    @Override
    public Point selectPutKomaPosition() {
        System.out.print("y : ");
        int y = sc.nextInt();
        System.out.print("x : ");
        int x = sc.nextInt();
        System.out.println();
        return new Point(x, y);
    }
}
