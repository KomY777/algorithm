package suanfaclass.suixianglu.doublezhizhen;

public class num27 {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int head = 0;
        int last = len-1;
        while (head <= last){
            while (head<=last &&nums[last]==val) last--;
            if( head>last){
                break;
            }
            if (nums[head] == val){
                nums[head]=nums[last--];
            }
            head++;
        }
        return head;
    }
}
