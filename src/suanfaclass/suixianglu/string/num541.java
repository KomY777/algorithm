package suanfaclass.suixianglu.string;

import java.util.Arrays;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
public class num541 {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg",8));

    }
    public static String reverseStr(String s, int k) {
        int len = s.length();
        int slow =0;
        int fast = k-1;
        char[] arr = s.toCharArray();
        while (fast<len){
            int head=slow;
            int last =fast;
            while (head<last){
                char temp = arr[last];
                arr[last]=arr[head];
                arr[head]=temp;
                head++;
                last--;
            }
            slow+=2*k;
            fast=slow+k-1;
        }
        int last = len-1;
        while (slow<last){
            char temp=arr[last];
            arr[last]=arr[slow];
            arr[slow]=temp;
            slow++;
            last--;
        }
        return String.valueOf(arr);
    }
}
