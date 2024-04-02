package suanfaclass.suixianglu.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 */
public class num530 {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        bfs(root,list);
        int min=Integer.MAX_VALUE;
        for (int i =1;i<list.size();i++){
            int t =list.get(i)-list.get(i-1);
            if (min>t){
                min=t;
            }
        }
        return min;
    }
    public void bfs(TreeNode root,List<Integer> list){
        if (root==null)return;
        bfs(root.left,list);
        list.add(root.val);
        bfs(root.right,list);
    }
}
