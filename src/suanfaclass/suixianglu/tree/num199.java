package suanfaclass.suixianglu.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class num199 {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, 0, map);
        for (Integer key :map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    public void dfs(TreeNode root, int dep, Map<Integer, Integer> map) {
        if (root == null) return;
        dep++;
        if (dep > map.size()) {
            map.put(dep, root.val);
        }
        dfs(root.right, dep, map);
        dfs(root.left, dep, map);
    }
}
