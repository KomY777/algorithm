package suanfaclass.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是
 * 回文串
 *  。返回 s 所有可能的分割方案。
 */
public class num131 {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtracking(s,0);
        return res;
    }
    public void backtracking(String s, int start){
        if(start>=s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i =start;i<s.length();i++){
            if(isPalidrome(s,start,i)){
                String sub = s.substring(start,i-start+2);
                path.add(sub);
            }else{
                continue;
            }
            backtracking(s,i+1);
            path.removeLast();
        }
    }
    public boolean isPalidrome(String s,int start,int end){
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
