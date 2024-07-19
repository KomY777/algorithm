package suanfaclass.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class num17 {
    static List<String> res = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {
        backtraking(digits,0);
        return res;
    }
    public static void backtraking(String str,int len){
        if(str.length()==len){
            res.add(String.valueOf(sb));
            return;
        }
        String target =numString[str.charAt(len)-'0'];
        for (int i=0;i<target.length();i++){
            sb.append(target.charAt(i));
            backtraking(str,len);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
