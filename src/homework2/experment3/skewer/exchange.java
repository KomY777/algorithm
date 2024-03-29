package homework2.experment3.skewer;

import static java.lang.Integer.parseInt;

public class exchange {
    public static void main(String[] args) {
        System.out.println(exchange("1.345e-2"));
    }
    public static double exchange(String str){
       String[] strs = str.split("e");
       double num = Double.parseDouble(strs[0]);
       int x = Integer.parseInt(strs[1]);
       if(x<0){
           for(int i = 0; i>x; i--){
               num /= 10;
           }
       }else {
           for (int i = 0; i < x; i++) {
               num *=10;
           }
       }
       return num;
    }
}
