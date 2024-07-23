package suanfaclass.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class num51 {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean[][] used = new boolean[n][n];
        backtracking(n,used,0);
        return res;
    }
    public void backtracking(int n, boolean[][] used,int level){
        if(path.size()==n){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i =0;i<n;i++){
            if(canput(i,n,used,level)){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(j==i){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                path.add(sb.toString());
                used[level][i]=true;
                backtracking(n,used,level+1);
                used[level][i]=false;
                path.removeLast();
            }
        }
    }
    public boolean canput(int p, int n,boolean[][] used,int level){
        for(int i=0;i<p;i++){
            if(used[level][i])return false;
        }
        for(int i=1,j=level-1;j>=0;i++,j--){
            if(used[j][p])return false;
            if(p-i>=0 &&used[j][p-i])return false;
            if(p+i<n&&used[j][p+i])return false;
        }
        return true;
    }
}
