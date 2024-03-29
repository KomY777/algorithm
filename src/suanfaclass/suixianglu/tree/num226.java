package suanfaclass.suixianglu.tree;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class num226 {
    public TreeNode invertTree(TreeNode root) {
        bfs(root);
        return root;
    }
    public void bfs(TreeNode root){
        if(root==null) return;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        bfs(root.left);
        bfs(root.right);
    }
}
