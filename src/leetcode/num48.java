package leetcode;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class num48 {
    public void rotate(int[][] matrix) {
        int[][] copy= new int[matrix.length][matrix[0].length];
        for (int i =0;i < matrix.length; i++){
            for (int j =0;j < matrix[0].length; j++){
               copy[i][j]=matrix[i][j];
            }
        }

        for (int i =0;i < copy.length; i++){
            for (int j =0;j < copy[i].length; j++){
                matrix[j][matrix.length-1-i]=copy[i][j];
            }
        }
    }
}
