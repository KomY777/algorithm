package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 查找只在字符串中出现过一次的字符,找到就输出他的下标，没找到就输出-1
 */

public class num378 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(myanser(str));
        System.out.println(new1(str));
    }
    static int myanser(String str){
        Map map = new HashMap<Integer, Integer>();
        for(int i = 0; i < str.length(); i++){
            if(!map.containsKey(str.charAt(i))) {
                for(int j = i+1; j < str.length(); j++){
                    if (str.charAt(i) == str.charAt(j)) {
                        map.put(str.charAt(j), j);
                        break;
                    }
                    if (j==str.length()-1) {
                        return i;
                    }
                }
            }else{
                continue;
            }
            if (i==str.length()-1) {
                return i;
            }
        }
        return -1;
    }
    static int new1(String s){
        int res = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = s.indexOf(ch);
            if (index != -1 && index == s.lastIndexOf(ch)) {
                res = (res == -1 || res > index) ? index : res;
            }
        }
        return res;
    }
}
