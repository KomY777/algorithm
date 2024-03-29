package homework2.StackAndQueue;

import java.util.Scanner;

public class MyQueue {
    private int head;
    private int tail;
    private int[] queue;
    public MyQueue(){
        queue = new int[100];
        head = tail = 0;
    }
    public void push(int x){
        queue[tail++] = x;
    }
    public int pop() {
        if(size() == 0){
            return 0;
        }else {
        return queue[head++];
        }
    }
    public int size() {
        return tail-head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        MyQueue queue = new MyQueue();
        while (total > 0) {
            switch (sc.nextInt()) {
                case 1:
                   queue.push(sc.nextInt());
                    total--;
                    break;
                case 2 :
                    int i = queue.pop();
                    if (i == 0) {
                        System.out.println("Invalid");
                    }else {
                        System.out.println(i);
                    }
                    total--;
                    break;
                case 3 :
                    System.out.println(queue.size());
                    total--;
                    break;
                default :
                    continue;
            }
        }
    }

}
