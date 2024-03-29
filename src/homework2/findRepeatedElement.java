package homework2;

import java.util.Scanner;

/**
 * 找到数组中重复的元素
 */
public class findRepeatedElement {
    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }

        System.out.print(containsDuplicate(array));
    }
    public static boolean containsDuplicate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if (nums[j] == nums[i]){
                    return true;
                }
            }
        }
        return false;
    }
}
