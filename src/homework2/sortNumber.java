package homework2;

import java.util.Scanner;

public class sortNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int[] temp = new int[len];
        mergesort(nums, 0, len - 1, temp);
        return nums[nums.length - k];
    }

    public static void mergesort(int[] nums, int left, int right, int[] temp) {
        if (right - left < 16) {
            insertsort(nums, left, right);
            return;
        }
        int mid = (right + left) / 2;
        mergesort(nums, left, mid, temp);
        mergesort(nums, mid, right, temp);
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
        }
    }

    public static void insertsort(int[] nums, int left, int right) {
        for (int i = left; i <= right; i++) {
            int temp = nums[i];
            int j;
            for (j = i; j > left; j--) {
                if (nums[j - 1] > temp) {
                    nums[j] = nums[j - 1];
                } else {
                    break;
                }
            }
        }
    }
}
