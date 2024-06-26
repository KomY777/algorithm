package leetcode;

import java.util.HashMap;
import java.util.Map;

public class num13 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int length = s.length();
        int nums = 0;
        for (int i = 0; i < length; i++) {
            if ( i < length-1  && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                nums -= map.get(s.charAt(i));
            } else {
                nums += map.get(s.charAt(i));
            }
        }
        return nums;
    }
}
