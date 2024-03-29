package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 *
 可被 5 整除的二进制前缀。
 */
public class num1018 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1,11,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,};
        List<Boolean> booleans = prefixesDivBy5(nums);
        System.out.println(booleans);
    }
    public static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int num=0;
        for (int i : nums) {
            num = (num * 2 + i) %10;
            result.add(num % 5 == 0);
        }
        return result;
    }
}
