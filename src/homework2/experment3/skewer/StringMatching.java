package homework2.experment3.skewer;

public class StringMatching {
    public static void main(String[] args) {
        System.out.println(Match("aaaab","aa"));
    }
    public static int Match(String s, String t){
        int num=0, i =0, j=0;
        while(i<s.length()){
            if(j==t.length()){
                num++;
                j=0;
                continue;
            }
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else {
                i++;
            }

        }
        return num;
    }
}
