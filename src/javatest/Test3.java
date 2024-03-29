package javatest;

import java.util.Scanner;

/**
 * @author kom
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一行字母：");
        String input = scanner.nextLine();

        int letterCount = 0;
        int spaceCount = 0;
        int digitCount = 0;
        int otherCount = 0;

        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(Character.isLetter(c)){
                letterCount++;
            }else if(Character.isDigit(c)){
                digitCount++;
            }else if(Character.isSpaceChar(c)){
                spaceCount++;
            }else{
                otherCount++;
            }
        }

        System.out.println("字母字数：" + letterCount);
        System.out.println("数字个数：" + digitCount);
        System.out.println("空格个数：" + spaceCount);
        System.out.println("其他字符个数：" + otherCount);
    }
}
