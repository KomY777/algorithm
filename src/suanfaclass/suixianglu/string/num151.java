package suanfaclass.suixianglu.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
public class num151 {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && sb.length()!=0) {
                list.add(sb.toString());
                sb = new StringBuilder();
            }
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            }
        }
        if (sb.length()!=0){
            list.add(sb.toString());
        }
        String[] strArr = list.toArray(new String[0]);
        int head = 0;
        int last = strArr.length - 1;
        while (head < last) {
            String temp = strArr[head];
            strArr[head] = strArr[last];
            strArr[last] = temp;
            head++;
            last--;
        }
        return String.join(" ", strArr);
    }
}
