package javatest;

import java.util.Scanner;

/**
 * @author kom
 */
public class Tset2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入学生成绩：");
        int score = scanner.nextInt();
        char grade = score >= 90 ? 'A' :(score >= 60 ? 'B' : 'C');
        System.out.println("学生成绩为：" + grade);
    }
}
