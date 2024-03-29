package suanfaclass.suixianglu.tree;

/**
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树
 */
public class num654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return findNode(nums,0,nums.length);
    }
    public TreeNode findNode(int[] nums,int left,int right){
        if (left>=right)return null;
        int max = nums[left];
        int index = left;
        for (int i = left+1; i < right; i++){
            if (nums[i] > max) {
                max = nums[i];
                index=i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left=findNode(nums,left,index);
        node.right=findNode(nums,index+1,right);
        return node;
    }
}
