package leetcode;

/**
 * 回文2,判断回文,并且允许可以删除一个字母来组成回文
 *
 * 目前还没解决bug
 *
 */
public class num680 {
    public static void main(String[] args) {
        String s ="aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(validPalindrome(s));
    }
    public static boolean validPalindrome(String s) {
        int i = 0, j =s.length() - 1, num = 0;
        while (i<j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (s.charAt(i+1) ==s.charAt(j)){
                    i += 2;
                    j--;
                    num++;
                }else if (s.charAt(i) ==s.charAt(j-1)){
                    j -= 2;
                    i++;
                    num++;
                }else{
                    return false;
                }
            }else{
            i++;
            j--;
            }
        }
        return num<=1 && (i != j || (s.charAt(i - 1) == s.charAt(j) || s.charAt(i) == s.charAt(j + 1) || s.charAt(i-1) == s.charAt(j+1)));
    }
}
