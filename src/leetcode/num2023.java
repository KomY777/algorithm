package leetcode;

/**
 * 找子串
 */
public class num2023 {
    public static void main(String[] args) {
        String[] nums = {"1","111"};
        String str ="11";
        System.out.println(numOfPairs(nums,str));
    }
    public static int numOfPairs(String[] nums, String target) {
        char[] t = target.toCharArray();
        int sum =0;
        for (int i = 0; i < nums.length; i++) {
            int j = 0;
            char[] p = nums[i].toCharArray();
            for (int k = 0; k < (Math.min(p.length, t.length)); k++) {
                if (t[k] == p[k]) {
                    j++;
                }else{
                    j=0;
                    break;
                }
            }
            if (j !=0){
                String str = target.substring(j);
                for(int k = 0; k < nums.length; k++) {
                    if (k == i){
                        continue;
                    }
                    if(nums[k].equals(str)) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }
}
