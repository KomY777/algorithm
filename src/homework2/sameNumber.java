package homework2;

import java.util.Scanner;

public class sameNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String stringArray[] = str.split(" ");
        int nums[] = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            nums[i] = Integer.parseInt(stringArray[i]);
        }
        System.out.println(judge(nums));
    }
    public static int judge(int[] nums){
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            int n =0;
            for (int j = i; j < nums.length; j++){
                if (nums[j] == nums[i]) {
                    n++;
                }else{
                    break;
                }
            }
            count = count>=n ? count : n;
        }
        return count;
    }
}
