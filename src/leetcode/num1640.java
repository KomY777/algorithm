package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 是否连接成数组
 */
public class num1640 {
    public static void main(String[] args) {
        int[] arr ={91,4,64,78};
        int[][] pieces = {{78},{4,64},{91}};
        System.out.println(canFormArray1(arr,pieces));
    }

    /**
     * 暴力算法
     * @param arr
     * @param pieces
     * @return
     */
    public static boolean canFormArray1(int[] arr, int[][] pieces) {

        for (int i = 0; i < arr.length;) {
            int k = 0;
            while (k < pieces.length && pieces[k][0] != arr[i]) {
                ++k;
            }
            if (k == pieces.length) {
                return false;
            }
            int j = 0;
            while (j < pieces[k].length && arr[i] == pieces[k][j]) {
                ++i;
                ++j;
            }
        }
        return true;
    }

    /**
     * 哈希表
     *
     * 记录pieces中每个数组的第一个元素，
     * 然后遍历arr数组找到arr中与map中第一个元素相对应的值，如果没有就返回false
     * @param arr
     * @param pieces
     * @return
     */
    public boolean canFormArray2(int[] arr, int[][] pieces) {
        Map<Integer, int[]> d = new HashMap<>();
//        遍历pieces将每个数组中的第一个元素存为key，将下标位置存为value方便查找时用
        for (int[] p : pieces) {
            d.put(p[0], p);
        }
//       设置一个i来方便查找数据
        for (int i = 0; i < arr.length;) {
//            如果哈希表中找不到这个key就说明pieces中没有和arr匹配的数据，可以直接返回false
            if (!d.containsKey(arr[i])) {
                return false;
            }
//            遍历piece中放入与arr中第i个值相等的键中的值,这里是从哈希表中拿出一个数组,将他遍历出来
            for (int v : d.get(arr[i])) {
//                如果遍历的数组与arr中有不同的元素则立刻返回false
                if (arr[i++] != v) {
                    return false;
                }
            }
        }
//        全部查询完后可以返回true
        return true;
    }
}
