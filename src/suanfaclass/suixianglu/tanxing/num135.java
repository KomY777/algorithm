package suanfaclass.suixianglu.tanxing;

import java.util.Arrays;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 */
public class num135 {
    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        Arrays.fill(res,1);
        for (int i =1;i<ratings.length;i++){
            if (ratings[i]>ratings[i-1]) res[i]=res[i-1]+1;
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                res[i]=Math.max(res[i],res[i+1]+1);
            }
        }
        return Arrays.stream(res).sum();
    }
}
