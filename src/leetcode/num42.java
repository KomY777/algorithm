package leetcode;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class num42 {
    public static void main(String[] args) {
        int[] ins = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap(ins);
    }

    public static int trap(int[] height) {
        int sum = 0;
        int slow = 0;
        int fast = 1;
        if (height.length < fast) return 0;
        while (fast < height.length) {
            while (height[slow] == 0) slow++;
            while (fast < height.length &&(height[fast] == 0 || slow >= fast)) fast++;
            if (fast>=height.length)break;
            if (height[slow] <= height[fast]) {
                int index = slow;
                while (index < fast) {
                    int temp = height[slow] - height[++index];
                    if (temp > 0) sum += temp;
                }
                slow = index;
                fast++;
                continue;
            }
            if (height[slow] > height[fast]) {
                int index = fast;
                while (slow < index) {
                    int temp = height[fast] - height[--index];
                    if (temp > 0) {
                        sum += temp;
                        height[index] = height[fast];
                    }
                }
                fast++;
            }
        }
        return sum;
    }
}
