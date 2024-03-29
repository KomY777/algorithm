package homework2;

import java.util.Scanner;

public class ShareStack {
    private int[] stack;
    private int i1;
    private int i2;
    public ShareStack(int a){
        stack = new int[a];
        i1 = 0;
        i2 = stack.length-1;
    }
    public void pop(int i){
        if (empty(i)){
            System.out.println("Empty stack!!");
            return;
        }
        if (i == 1){
            i1--;
        }else{
            i2++;
        }
    }
    public void push(int i, int x){
        if (full()){
            System.out.println("Stack is full");
            return;
        }
        if (i == 1){
            stack[i1] = x;
            i1++;
        }else{
            stack[i2] = x;
            i2--;
        }
    }
    public boolean empty(int i){
        if (i == 1){
            return i1==0;
        }else{
            return i2==stack.length-1;
        }
    }
    public boolean full() {
        return i1==i2;
    }
}

