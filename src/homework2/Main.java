package homework2;

import java.util.*;
import java.util.Scanner;

public class Main {
    static Stack <Double> opand=new Stack <Double>();
    static Stack <String> oper=new Stack <String>();
    public static boolean Same(String s1,String s2) {
        return s1.compareTo(s2)==0;
    }
    public static void comp(String op) {
        double a=opand.pop();
        double b=opand.pop();
        double c=0.0;
        if (Same(op,"+"))
            c=b+a;
        else if (Same(op,"-"))
            c=b-a;
        else if (Same(op,"*"))
            c=b*a;
        else if (Same(op,"/"))
            c=b/a;
        opand.push(c);
    }
    public static void main(String[] args) {
        Scanner fin = new Scanner(System.in);
        while (fin.hasNext()) {
            String str=fin.nextLine();
            if (str.compareTo("0")==0)
                break;
            opand.clear();
            oper.clear();
            String[] strs=str.split(" ");
            String op;
            int i=0;
            while (i <strs.length) {
                if (Same(strs[i],"*") || Same(strs[i],"/")) {
                while (!oper.empty()) {
                    op=oper.peek();
                if (Same(op,"*") || Same(op,"/")) {
                    comp(op);
                    oper.pop();
                }
                else break;
            }
                oper.push(strs[i]);
            }
            else if (Same(strs[i],"+") || Same(strs[i],"-")) {
                while (!oper.empty()) {
                    op=oper.pop();
                comp(op);
            }
                oper.push(strs[i]);
            }
            else
                opand.push(Double.parseDouble(strs[i]));
                i++;
            }
            while (!oper.empty()) {
                op=oper.pop();
                comp(op);
            }
            System.out.printf("%.2f", opand.peek());
            System.out.println();
        }
    }
}