package suanfaclass.suixianglu.string;

/**
 * 字符串的右旋转操作是把字符串尾部的若干个字符转移到字符串的前面。给定一个字符串 s 和一个正整数 k，请编写一个函数，
 * 将字符串中的后面 k 个字符移到字符串的前面，实现字符串的右旋转操作。
 * 例如，对于输入字符串 "abcdefg" 和整数 2，函数应该将其转换为 "fgabcde"。
 */
public class youxuanzifuchuan {
    public static void main(String[] args) {
        System.out.println(rightCornerStr("abcdefg",2));
    }

    public static String rightCornerStr(String s, int k){
        char[] chars = s.toCharArray();
        int len = s.length();
        int last = len-1;
        int head = last-k;
        while (head>=0){
            char temp = chars[last];
            chars[last]=chars[head];
            chars[head]=temp;
            head--;
            last--;
        }
        return String.valueOf(chars);
    }

}
