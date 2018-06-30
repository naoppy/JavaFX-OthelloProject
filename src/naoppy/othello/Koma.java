package naoppy.othello;

/**
 * オセロの駒を表す列挙型
 */
public enum Koma {
    /**
     * 番兵として盤上を囲うように設置される壁
     */
    WALL,
    /**
     * まだどのプレイヤーも取っていない場所
     */
    NONE,
    /**
     * 白のプレイヤーの駒
     */
    WHITE,
    /**
     * 黒のプレイヤーの駒
     */
    BLACK;
}
