package suanfaclass.suixianglu.tree;


/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 */
public class num513 {
    public int maxdep = 0;
    public int index = 0;

    public int findBottomLeftValue(TreeNode root) {
        index = root.val;
        bfs(root, 1);
        return index;
    }

    public void bfs(TreeNode root, int dep) {
        if (root == null) return;
        if (root.left==null&&root.right==null) {
            if (dep > maxdep) {
                maxdep = dep;
                index = root.val;
            }
        }
        if (root.left != null) {
            bfs(root.left, dep+1);
        }
        if (root.right != null) {
            bfs(root.right, dep+1);
        }
    }
}
