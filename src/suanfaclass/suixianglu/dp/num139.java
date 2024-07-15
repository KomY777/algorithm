package suanfaclass.suixianglu.dp;

import java.util.HashSet;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class num139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0]=1;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i && dp[i] == 0; j++) {
                if (set.contains(s.substring(j,i)) && dp[j] == 1) {
                    dp[i] = 1;
                }
            }
        }
        return dp[len] == 1;
    }
}
