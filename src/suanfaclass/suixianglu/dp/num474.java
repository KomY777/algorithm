package suanfaclass.suixianglu.dp;

/**
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 */
public class num474 {
    public static void main(String[] args) {
        String[] strs = {"10","0001","111001","1","0"};
        System.out.println(findMaxForm(strs,5,3));
    }
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeroNum = 0, oneNum = 0;
            for (char s: str.toCharArray()) {
                if (s == '0') zeroNum++;
                else oneNum++;
            }
            for (int i =m;i>=zeroNum;i--){
                for (int j = n;j>=oneNum;j--){
                    dp[i][j] = Math.max(dp[i][j],dp[i-zeroNum][j-oneNum]+1);
                }
            }
        }
        return dp[m][n];
    }

}
