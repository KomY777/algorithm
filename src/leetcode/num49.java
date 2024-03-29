package leetcode;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */
public class num49 {
    public static void main(String[] args) {
        String[] strings ={"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = groupAnagrams(strings);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultmap = new HashMap<>();
        Map<Character, Integer> charmap = new HashMap<>();
        Map<Integer, Character> numMap = new HashMap<>();
        int num = 1;
        for (String str : strs) {
            char[] chars = str.toCharArray();
            List<Integer> nums = new ArrayList<>();
            for (char c : chars) {

                if (!charmap.containsKey(c)){
                    charmap.putIfAbsent(c, num++);
                    numMap.putIfAbsent(num, c);
                }

                nums.add(charmap.get(c));
            }
            StringBuilder s = new StringBuilder();
            for (int i =0;i< nums.size();i++){
                for (int j = i+1;j< nums.size();j++){
                    if (nums.get(i) > nums.get(j)){
                        int temp = nums.get(i);
                        nums.set(i, nums.get(j));
                        nums.set(j, temp);
                    }
                }

            }
            for (Integer n : nums) {
                s.append(numMap.get(n));
            }
            resultmap.computeIfAbsent(s.toString(), k -> new ArrayList<>());
            resultmap.get(s.toString()).add(str);
        }
        return new ArrayList<>(resultmap.values());
    }
}
