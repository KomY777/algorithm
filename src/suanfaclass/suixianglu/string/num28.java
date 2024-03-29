package suanfaclass.suixianglu.string;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle
 * 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 */
public class num28 {
    public int strStr(String haystack, String needle) {
        int i =0;
        int[] next = new int[needle.length()];
        for (int j=1;j<=needle.length();j++){
            while (i>0 && needle.charAt(i)!=needle.charAt(j)){
                i=next[i-1];
            }
            if (needle.charAt(j)==needle.charAt(i)){
                i++;
            }
            next[j]=i++;
        }
        i=0;
        for (int j=0;j<=haystack.length();j++){
            while (i>0 && haystack.charAt(j)!=needle.charAt(i)){
                i=next[i-1];
            }
            if (haystack.charAt(j)==needle.charAt(i)){
                i++;
            }
            if (i == needle.length())
                return j - needle.length() + 1;
        }
        return -1;
    }
}