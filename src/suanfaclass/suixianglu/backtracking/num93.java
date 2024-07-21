package suanfaclass.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */
public class num93 {
    LinkedList<String> res = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder(s);
        backtracking(sb,0,0);
        return res;
    }
    public void backtracking(StringBuilder s, int start,int point){
        if(point==3){
            if(isValid(s,start,s.length()-1)){
                res.add(s.toString());
            }
            return;
        }
        for (int i = start;i<s.length();i++){
            if(isValid(s,start,i)){
                s = s.insert(i+1,".");
                point++;
                backtracking(s,i+2,point);
                point--;
                s = s.delete(i+1,i+2);
            }else{
                break;
            }
        }
    }
    public boolean isValid(StringBuilder s,int start ,int end){
        if(start>end)return false;
        if(s.charAt(start)=='0' && start<end)return false;
        int num=0;
        for(int i=start;i<=end;i++){
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
