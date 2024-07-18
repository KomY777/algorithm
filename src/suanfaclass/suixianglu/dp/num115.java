package suanfaclass.suixianglu.dp;

/**
 *给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 109 + 7 取模。
 */
public class num115 {
    public int numDistinct(String s, String t) {
        int slen = s.length(),tlen=t.length();
        int[][] dp =new int[slen+1][tlen+1];
        for (int i =0;i<slen;i++){
            dp[i][0]=1;
        }
        for(int i =1;i<tlen;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=slen;i++){
            for(int j =1;j<=tlen;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[slen][tlen];
    }
}
