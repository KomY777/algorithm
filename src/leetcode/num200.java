package leetcode;
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
//岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
//此外，你可以假设该网格的四条边均被水包围。
public class num200 {
    public int numIslands(char[][] grid) {
        int n = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    n+=1;
                    solve(grid,i,j);
                }
            }
        }
        return n;
    }
    public void solve(char[][] grid,int i,int j) {
        if (i<0 || j<0 ||i>grid.length-1 || j>grid[i].length-1) return;
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
        }else{
            return;
        }
        solve(grid,i-1,j);
        solve(grid,i+1,j);
        solve(grid,i,j-1);
        solve(grid,i,j+1);
    }
}
