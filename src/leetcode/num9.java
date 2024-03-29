package leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class num9 {
    public boolean isPalindrome(int x) {
        String a = "" + x;
        char[] chars = a.toCharArray();
        int i = 0;
        int j = chars.length-1;
        while(i<j){
            if (chars[i]!= chars[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
