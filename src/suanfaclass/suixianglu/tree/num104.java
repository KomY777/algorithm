package suanfaclass.suixianglu.tree;

/**
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */
public class num104 {
    public int maxDepth(TreeNode root) {
        return bfs(root,0);
    }
    public int bfs(TreeNode root,int dep){
        if (root==null)return dep;
        dep++;
        return Math.max(bfs(root.left,dep),bfs(root.right,dep));
    }
}
