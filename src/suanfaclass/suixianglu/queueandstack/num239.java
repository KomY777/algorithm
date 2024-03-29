package suanfaclass.suixianglu.queueandstack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值。
 */
public class num239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int max = Integer.MIN_VALUE;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int slow = 0;
        int fast = 0;
        while (fast < len) {
            // 构建窗口
            while(!queue.isEmpty() && queue.peek() < fast - k + 1){
                queue.poll();
            }
            // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[fast]) {
                queue.pollLast();
            }
            queue.offer(fast);
            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if(fast >= k - 1){
                res[slow++] = nums[queue.peek()];
            }
            fast++;
        }
        return res;
    }
}
