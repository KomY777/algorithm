package leetcode;



public class num997 {
    /**
    通过计算图的入度和出度来找到法官
    先创建两个数组来保存一个人的入度和出度，如果这个人相信了人出度加1如果这个人被别人相信，入度加1。
    当这个人的入度为n-1，出度为0时就可以判断出这个人是法官。
     */
    public int  findJudge1(int n, int[][] trust){
        int[] inDegrees = new int[n + 1];
        int[] outDegrees = new int[n + 1];
        for (int[] edge : trust) {
            int x = edge[0], y = edge[1];
            ++inDegrees[y];
            ++outDegrees[x];
        }
        for (int i = 1; i <= n; ++i) {
            if (inDegrees[i] == n - 1 && outDegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }
    /**
    信任值解法
    设置一个数组存储每个人的信任值，当这个人被人信任时，信任值加1当他信任别人时，信任值减1
    如果这个人被所有人信任且不信任任何人那他的信任值为n-1，就可以找出这个人是法官
     */
    public int findJudge2(int n, int[][] trust) {
//        创建一个数组用来存储这个人的信任值
        int[] trusts = new int[n + 1];
//        遍历trust中的元素,如果一个人被信任就++,如果信任别人就--
        for (int[] t : trust) {
           trusts[t[1]]++;
           trusts[t[0]]--;
        }
//        遍历一次trusts数组来查看信任值就可以找出谁是法官了
        for (int i = 1; i <= trusts.length; ++i) {
            if (trusts[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}
