package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号
 */
public class num2755 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        def(res,n,n,"");
        return res;
    }
    private static void def(List<String> res, int left, int right, String str) {
        if(left ==0 && right ==0){
            res.add(str);
            return;
        }
        if(left < 0){
            return;
        }
        if(right<left){
            return;
        }
        def(res,left-1,right,str+"(");
        def(res,left,right-1,str+")");
    }
}
