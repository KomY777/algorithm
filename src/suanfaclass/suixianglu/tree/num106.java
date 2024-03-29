package suanfaclass.suixianglu.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 */
public class num106 {
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) { // 用map保存中序序列的数值对应位置
            map.put(inorder[i], i);
        }
        return findNode(inorder, postorder, 0, inorder.length, 0, postorder.length);
        }
        public TreeNode findNode(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd){
        if (inStart>=inEnd||postStart>=postEnd)return null;
        int index = map.get(postorder[postEnd-1]);
        TreeNode node = new TreeNode(inorder[index]);
        node.left = findNode(inorder,postorder,inStart,index,postStart,postStart+index-inStart);
        node.right= findNode(inorder,postorder,index+1,inEnd,postStart+index-inStart,postEnd-1);
        return node;
    }
}
