package suanfaclass.suixianglu.queueandstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 */
public class num150 {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        for (String s: tokens){
            if(!(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/"))){
                stack.push(s);
                continue;
            }
            int sum=0;
            int num2 = Integer.parseInt(stack.pop());
            int num1 = Integer.parseInt(stack.pop());
            if (s.equals("+")){
                sum=num1+num2;
            }
            if (s.equals("-") ){
                sum=num1-num2;
            }
            if( s.equals("*") ){
                sum=num1*num2;
            }
            if ( s.equals("/")){
                sum=num1/num2;
            }
            stack.push(String.valueOf(sum));
        }
        return Integer.parseInt(stack.pop());
    }
}
