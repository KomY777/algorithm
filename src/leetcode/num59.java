package leetcode;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class num59 {
    public int[][] generateMatrix(int n) {
        int len = n*n;
        int[][] matrix = new int[n][n];
        int x = 0,y = 0;
        int l = 0, r = n-1, t = 0, b = n-1;
        int count = 1;
        while(count <= len){
            for (;x<r;x++)matrix[y][x] = count++;
            r--;
            for (;y<b;y++)matrix[y][x] = count++;
            b--;
            for (;x>l;x--)matrix[y][x] = count++;
            l++;
            for (;y>t;y--)matrix[y][x] = count++;
            t++;
        }
        return matrix;
    }
}
