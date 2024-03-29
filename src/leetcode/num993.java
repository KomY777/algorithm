package leetcode;

import leetcode.ListNode.TreeNode;

/**
 * 二叉树的堂兄弟节点
 */
public class num993 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.right = t3;
        t2.right = t4;
        t3.left = t5;
        isCousins(t1, 5, 4);
    }



    public static boolean isCousins(TreeNode root, int x, int y) {
        if (x == y) {
            return false;
        }
        TreeNode findx = findNode(root, x, 0);
        TreeNode findy = findNode(root, y, 0);
        if (findx == findy || findx == null || findy == null) {
            return false;
        }
        return findx.val == findy.val;
    }

    public static TreeNode findNode(TreeNode root, int num, int cen) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            if (root.left.val == num) {
                root.val = cen;
                return root;
            }
        }
        if (root.right != null) {
            if (root.right.val == num) {
                root.val = cen;
                return root;
            }
        }
        TreeNode flag = findNode(root.left, num, cen + 1);
        return flag != null ? flag : findNode(root.right, num, cen + 1);
    }
}
