package suanfaclass.suixianglu.tree;

/**
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 */
public class num404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return bfs(root,false);
    }
    public int bfs(TreeNode root, boolean isleft){
        if (root==null)return 0;
        if (isleft && root.left==null && root.right==null) return root.val;
        return bfs(root.left,true)+bfs(root.right,false);
    }
}
