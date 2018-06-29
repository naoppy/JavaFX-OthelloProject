package naoppy.othello;

import java.awt.*;

public class CUIOthello implements Runnable {
    /**
     * 2人のプレイヤー
     */
    private OthelloPlayer player1;
    private OthelloPlayer player2;
    /**
     * オセロの盤
     */
    private OthelloField othelloField = new OthelloField();

    /**
     * 渡された二つのプレイヤーを登録します
     * @param p1 プレイヤー1
     * @param p2 プレイヤー2
     */
    public CUIOthello(OthelloPlayer p1, OthelloPlayer p2) {
        this.player1 = p1;
        this.player2 = p2;
    }

    public void run() {
        for(int i = 0; i < 60; i++) {
            System.out.println(othelloField.getNextIsWhite() ? "白のターン" : "黒のターン");
            System.out.println(this.DecorateOthelloField());
            input();
        }
        System.out.println(DecorateOthelloField());
    }

    private void input() {
        OthelloPlayer puttingPlayer = othelloField.getNextIsWhite() ? player1 : player2;
        Point p;
        do {
            p = puttingPlayer.selectPutKomaPosition();
        } while(!othelloField.putNewKoma(p.y, p.x));
    }

    /**
     * オセロの文字列表現を分かりやすく整形します
     * @return 装飾されたオセロの盤の文字列表現
     */
    private String DecorateOthelloField() {
        StringBuilder sb = new StringBuilder();
        String header = " 01234567\n";
        sb.append(header);
        String[] gyous = othelloField.toString().split("\n");
        for(int i = 0; i < gyous.length; i++) {
            sb.append(i).append(gyous[i]);
            if(i != gyous.length-1) sb.append("\n");
        }
        return sb.toString();
    }
}
