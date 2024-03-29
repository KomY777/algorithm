package suanfaclass.suixianglu.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 */
public class num349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums1){
            set1.add(num);
        }
        for (int num :nums2){
            if (set1.contains(num)){
                list.add(num);
                set1.remove(num);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
