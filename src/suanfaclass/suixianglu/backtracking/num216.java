package suanfaclass.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
public class num216 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path =  new LinkedList<>();

    public static void main(String[] args) {
        combinationSum3(9,45);
        System.out.println(res);
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        backtarcking(n,k,1,0);
        return res;
    }
    public static void backtarcking(int n,int k,int start,int sum){
        if(sum>n)return;
        if(path.size()==k){
            if(n==sum)res.add(new ArrayList<>(path));
            return;
        }
        for(int i =start;i<=9-(k-path.size())+1;i++){
            path.add(i);
            sum+=i;
            System.out.println(path);
            System.out.println(sum);
            backtarcking(n,k,i+1,sum);
            sum-=i;
            path.removeLast();
        }
    }
}
