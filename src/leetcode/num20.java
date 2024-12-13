package leetcode;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//每个右括号都有一个对应的相同类型的左括号。

import java.util.Stack;

public class num20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stack.isEmpty()||c!=stack.peek()){
                if(c=='('){
                    stack.push(')');
                }else if(c=='['){
                    stack.push(']');
                }else if(c=='{'){
                    stack.push('}');
                }else {
                    return false;
                }
            }else if(stack.peek() == c){
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
