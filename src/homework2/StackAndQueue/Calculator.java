package homework2.StackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String notation = scanner.next();
        List<String> str1 = parseSuffixNotation(toInfixNotation(notation));
        if (calculate(str1)[1] == 1) {
            System.out.println(calculate(str1)[0]);
        } else {
            System.out.println("ILLEGAL");
        }
    }

    public static List<String> toInfixNotation(String s) {
        List<String> ls = new ArrayList<>();
        String str;
        char c;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) < 48 || s.charAt(i) > 57) {
                ls.add(s.charAt(i) + "");
            } else {
                str = "";
                int j = i;
                while (j < s.length() && s.charAt(j) >= 48 && s.charAt(j) <= 57) {
                    if (j > i) {
                        i ++;
                    }
                    str += s.charAt(j);
                    j ++;
                }
                ls.add(str);
            }
        }
        return ls;
    }

/**
 *
    符号栈
 */
    public static List<String> parseSuffixNotation(List<String> ls) {
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<String>();
        for (String item: ls) {
            if (item.matches("\\d+") ) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else if (item.equals("+") || item.equals("-")) {
                int count = 0;
                while (s1.size() != 0) {
                    if (s1.peek().equals("(")) {
                        break;
                    }
                    s2.add(s1.pop());
                }
                s1.push(item);
            } else if (item.equals("*") || item.equals("/")) {
                s1.push(item);
            }
        }
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    public static int[] calculate(List<String> ls) {
        int n = 1;
        int[] arr = new int[2];
        Stack<Integer> stack = new Stack<>();
        Quit :
        for (int i = 0;i < ls.size(); i ++) {
            int a;
            int b;
            int result;

            switch (ls.get(i)) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    result = b + a;
                    stack.push(result);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    result = b - a;
                    stack.push(result);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    result = b * a;
                    stack.push(result);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    if (a == 0) {
                        n = 0;
                        break Quit;
                    }
                    result = b / a;
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.parseInt(ls.get(i)));
                    break;
            }
        }
        arr[0] = stack.pop();
        arr[1] = n;
        return arr;
    }
}
