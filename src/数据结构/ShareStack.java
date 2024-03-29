package 新建文件夹;

public class ShareStack {
    private int[] stack;
    private int i1;
    private int i2;
    public ShareStack(int a){
        stack = new int[a];
        i1 = -1;
        i2 = stack.length;
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
            stack[++i1] = x;
        }else{
            stack[--i2] = x;
        }
    }
    public boolean empty(int i){
        if (i == 1){
            return i1==-1;
        }else{
            return i2==stack.length;
        }
    }
    public boolean full() {
        return i1==i2;
    }
}
