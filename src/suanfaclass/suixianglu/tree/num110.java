package suanfaclass.suixianglu.tree;

/**
 * 给定一个二叉树，判断它是否是
 * 平衡二叉树
 *
 */
public class num110 {
    public boolean isBalanced(TreeNode root) {
        return bfs(root) != -1;
    }
    public int bfs(TreeNode root){
        if (root == null)return 0;
        int left =bfs(root.left);
        if (left==-1)return -1;
        int right=bfs(root.right);
        if (right==-1)return -1;
        if (Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right)+1;
    }
}
