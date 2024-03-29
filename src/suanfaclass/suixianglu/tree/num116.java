package suanfaclass.suixianglu.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */
class node {
    public int val;
    public node left;
    public node right;
    public node next;

    public node() {}

    public node(int _val) {
        val = _val;
    }

    public node(int _val, node _left, node _right, node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class num116 {
    public node connect(node root) {
        Map<Integer, node> map = new HashMap<>();
        bfs(root, 0, map);
        return root;
    }

    public void bfs(node root, int dep, Map<Integer, node> map) {
        if (root == null) return;
        dep++;
        if (!map.containsKey(dep)){
            map.put(dep, root);
        }else {
            node node = map.get(dep);
            node.next = root;
            map.put(dep, root);
        }
        bfs(root.left, dep, map);
        bfs(root.right, dep, map);
    }
}
