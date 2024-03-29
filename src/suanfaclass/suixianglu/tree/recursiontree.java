package suanfaclass.suixianglu.tree;

import java.util.ArrayList;
import java.util.List;

public class recursiontree {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorder(root, result);
        return result;
    }
    public List<Integer> secorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        secorder(root, result);
        return result;
    }
    public List<Integer> lasorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        lasorder(root, result);
        return result;
    }

    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }
    public void secorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        secorder(root.left, result);
        result.add(root.val);
        secorder(root.right, result);
    }
    public void lasorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        lasorder(root.left, result);
        result.add(root.val);
        lasorder(root.right, result);
    }
}
