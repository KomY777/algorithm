package leetcode;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */
public class num75 {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 2) {
                int color = nums[i];
                nums[i] = nums[right];
                nums[right] = color;
                right--;
            }
            if (nums[i] == 0) {
                int color = nums[i];
                nums[i] = nums[left];
                nums[left] = color;
                left++;
            }
        }
    }
}
