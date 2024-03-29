package homework2.StackAndQueue;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TrainQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] train = new int[n];
        for (int i  = 0; i < n; i ++) {
            train[i] = scanner.nextInt();
        }
        ArrayList<Stack<Integer>> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            if (arrayList.size() == 0) {
                Stack<Integer> stack0 = new Stack<>();
                stack0.push(train[0]);
                arrayList.add(stack0);
            } else {
                int j = 0;
                for (; j < arrayList.size(); j ++) {
                    if (train[i] < arrayList.get(j).peek()) {
                        arrayList.get(j).push(train[i]);
                        break;
                    }
                }
                if (j == arrayList.size()) {
                    Stack<Integer> stack1 = new Stack<>();
                    stack1.push(train[i]);
                    arrayList.add(stack1);
                }
            }
        }

        for (int i = 0; i < arrayList.get(0).size() - 1; i ++) {
            System.out.print(arrayList.get(0).get(i) + " ");
        }
        System.out.println(arrayList.get(0).pop());
        System.out.println(arrayList.size());
    }
}
