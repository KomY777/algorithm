package suanfaclass.suixianglu.dp;

import java.util.Arrays;

/**
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 * 每步 可以删除任意一个字符串中的一个字符。
 */
public class num583 {
    public static void main(String[] args) {
                System.out.println(minDistance("a","b"));
    }
    public static int minDistance(String word1, String word2) {
        int len1= word1.length(),len2=word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i =0;i<=len1;i++){
            dp[i][0]=i;
        }
        for(int i =0;i<=len2;i++){
            dp[0][i]=i;
        }
        System.out.println(Arrays.deepToString(dp));
        for (int i= 1;i<=len1;i++){
            for(int j =1;j<=len2;j++){
                if(word1.charAt(i-1)!=word2.charAt(j-1)){
                    dp[i][j]=Math.min(dp[i-1][j-1]+1,Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }else {
                    dp[i][j]=dp[i][j]=dp[i-1][j-1];
                }
                System.out.println(Arrays.deepToString(dp));
            }
        }
        return dp[len1][len2];
    }
}
