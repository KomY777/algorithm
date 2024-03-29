package leetcode;

import java.util.Scanner;

/**
 * 扫雷
 */
public class num529 {
        // 定义 8 个方向
        static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
        static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
        static char[][] board;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("choose :\n1.easy\n2.medium\n3.expeert");
        int[] click = new int[2];
        switch (scanner.nextInt()) {
            case 1:
                board =new char[9][9];
                board = initalize(board,10);
                while(checkEnd(board)) {
                    System.out.println("enter site to click");
                    click[0] = scanner.nextInt();
                    click[1] = scanner.nextInt();
                    updateBoard(board, click);
                    System.out.println(board);
                }
                break;
            case 2 :
                board= new char[16][16];
                board = initalize(board,40);
                while(checkEnd(board)) {
                    System.out.println("enter site to click");
                    click[0] = scanner.nextInt();
                    click[1] = scanner.nextInt();
                    updateBoard(board, click);
                    System.out.println(board);
                }
                break;
            case 3 :
                board = new char[30][16];
                while(checkEnd(board)) {
                    System.out.println("enter site to click");
                    click[0] = scanner.nextInt();
                    click[1] = scanner.nextInt();
                    updateBoard(board, click);
                    System.out.println(board);
                }
                break;
            default :
                System.out.println("enter the right number!!");
        }
    }
//    初始化扫雷盘
    public static char[][] initalize(char[][] board, int num) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int x = (int)(Math.random()*10);
                if (num!=0) {
                    if (x > 6) {
                        board[i][j] = 'M';
                        num--;
                        continue;
                    }
                }
                if (x <=6){
                    board[i][j] = 'E';
                }
            }
        }
        return board;
    }

    public static boolean checkEnd(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] =='X' ) {
                    return false;
                }
            }
        }
        return true;
    }

        public static char[][] updateBoard(char[][] board, int[] click) {
            int x = click[0], y = click[1];
            // 1. 若起点是雷，游戏结束，直接修改 board 并返回。
            if (board[x][y] == 'M') {
                board[x][y] = 'X';
            } else {
                // 2. 若起点是空地，则从起点开始向 8 邻域的空地进行深度优先搜索。
                dfs(board, x, y);
            }
            return board;
        }

        private static void dfs(char[][] board, int i, int j) {
            // 递归终止条件：判断空地 (i, j) 周围是否有雷，若有，则将该位置修改为雷数，终止该路径的搜索。
            int cnt = 0;
            for (int k = 0; k < 8; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                    continue;
                }
                if (board[x][y] == 'M') {
                    cnt++;
                }
            }
            if (cnt > 0) {
                board[i][j] =  (char)(cnt + '0');
                return;
            }

            // 若空地 (i, j) 周围没有雷，则将该位置修改为 ‘B’，向 8 邻域的空地继续搜索。
            board[i][j] = 'B';
            for (int k = 0; k < 8; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') {
                    continue;
                }
                dfs(board, x, y);
            }
        }
}
