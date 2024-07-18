package suanfaclass.suixianglu.dp;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。
 * 在这种情况下，你会怎样改变代码？
 */
public class num392 {
    public boolean isSubsequence(String s, String t) {
        int slen=s.length(),tlen=t.length();
        int[][] dp = new int[tlen+1][slen+1];
        for(int i =1;i<=tlen;i++){
            for(int j =1;j<=slen;j++){
                if(t.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[tlen][slen]==slen;
    }
    public boolean doublezhizhen(String s, String t) {
        int slen=s.length(),tlen=t.length();
        int l = 0;
        for (int i = 0,j=0;i<tlen&&j<slen;i++){
            if(t.charAt(i)==s.charAt(j)){
                l++;
                j++;
            }
        }
        return l==slen;
    }
}
