package suanfaclass.suixianglu.backtracking;

import java.util.Arrays;

/**
 * 编写一个程序，通过填充空格来解决数独问题。
 * 数独的解法需 遵循如下规则：
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 */
public class num37 {
    public static void main(String[] args) {
        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    public static void solveSudoku(char[][] board) {
        backtracking(board, 0, 0);
    }

    public static boolean backtracking(char[][] board, int level, int start) {
        if (level >= board.length) return true;
        for (int i = start; i < board.length; i++) {
            if (board[level][i] != '.') continue;
            for (char j = '1'; j <= '9'; j++) {
                if (canPut(board, level, i, j)) {
                    board[level][i] =j;
                    if (i + 1 >= board.length) {
                        if (backtracking(board, level + 1, 0)) {
                            return true;
                        }
                    } else {
                        if (backtracking(board, level, i + 1)) {
                            return true;
                        }
                    }
                    board[level][i] = '.';
                }
            }
            return false;
        }
        if (backtracking(board, level + 1, 0)) {
            return true;
        }
        return false;
    }

    public static boolean canPut(char[][] board, int level, int p, char num) {
        for (int i = 0; i < board.length; i++) {
            if (board[level][i] == num) return false;
            if (board[i][p] == num) return false;
        }
        int x = (level/3)*3, y = (p / 3)*3;
        for (int i = x; i < x+3; i++) {
            for (int j = y; j <y+ 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }
}
