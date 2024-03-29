package 新建文件夹;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CirculQueue {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1;i<n;i++){
            queue.offer(i);
        }
        int  count = 0;
        while (!queue.isEmpty()) {
            count++;
            Integer person = queue.poll();
            if(count %m == 0){
                System.out.println(person+"  ");
            }else{
                queue.add(person);
            }
        }
        scanner.close();
    }
}
