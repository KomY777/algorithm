package suanfaclass.suixianglu.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 */
public class num429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }
    public void dfs(Node root, int dep, List<List<Integer>> list){
        if (root==null)return;
        dep++;
        if (dep>list.size()){
            list.add(new ArrayList<>());
        }
        list.get(dep-1).add(root.val);
        for (Node node :root.children){
            dfs(node,dep,list);
        }
    }
}
