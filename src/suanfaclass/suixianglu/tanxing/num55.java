package suanfaclass.suixianglu.tanxing;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false
 */
public class num55 {
    public int jump(int[] nums) {
        if(nums.length<=1)return 0;
        int res=1,cover=0;
        int curdis=nums[0];
        for (int i =0;i<nums.length-1;i++){
            cover=Math.max(i+nums[i],cover);
            if(curdis==i){
                res++;
                curdis=cover;
            }
        }
        return res;
    }
}
