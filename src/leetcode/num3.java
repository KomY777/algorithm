package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class num3 {
    public int lengthOfLongestSubstring(String s) {
        int length =0;
        for (int i = 0; i < s.length(); i++){
            Set<Character> set= new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i+1; j < s.length(); j++){
                if (set.contains(s.charAt(j)))break;
                set.add(s.charAt(j));
            }
            length = Math.max(length,set.size());
        }
        return length;
    }
}
