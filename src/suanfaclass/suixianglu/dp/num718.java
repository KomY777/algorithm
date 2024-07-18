package suanfaclass.suixianglu.dp;

/**
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 */
public class num718 {
    public int findLength(int[] nums1, int[] nums2) {
        int len1=nums1.length,len2=nums2.length;
        int[][] dp = new int[len1+1][len2+1];
        int res = 0;
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(nums1[i-1]==nums2[j-1]) dp[i][j] = dp[i-1][j-1]+1;
                if(dp[i][j]>res) res = dp[i][j];
            }
        }
        return res;
    }
}
