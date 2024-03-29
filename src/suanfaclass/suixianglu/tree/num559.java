package suanfaclass.suixianglu.tree;

/**
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）
 */
public class num559 {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int max = 1;
        for (Node node : root.children) {
            max = Math.max(max, maxDepth(node) + 1);
        }
        return max;
    }
}
