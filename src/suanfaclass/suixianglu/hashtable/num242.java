package suanfaclass.suixianglu.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 */
public class num242{
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        if (schar.length!=tchar.length){
            return false;
        }
        for (char c : schar) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : tchar){
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for (char c :schar){
            if (map.get(c) != 0){
                return false;
            }
        }
        return true;
    }
}
