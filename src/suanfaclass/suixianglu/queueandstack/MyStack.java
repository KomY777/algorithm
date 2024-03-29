package suanfaclass.suixianglu.queueandstack;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> queueIn;
    Queue<Integer> queueout;
    public MyStack() {
        queueIn = new LinkedList<>();
        queueout = new LinkedList<>();
    }

    public void push(int x) {
        queueout.offer(x); // 先放在辅助队列中
        while (!queueIn.isEmpty()){
            queueout.offer(queueIn.poll());
        }
        Queue<Integer> queueTemp;
        queueTemp = queueIn;
        queueIn = queueout;
        queueout = queueTemp;
    }

    public int pop() {
        return queueIn.poll();

    }

    public int top() {
        return queueIn.peek();
    }

    public boolean empty() {
        return queueIn.isEmpty();
    }
}