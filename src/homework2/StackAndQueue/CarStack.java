package homework2.StackAndQueue;

import java.util.ArrayList;
import java.util.Scanner;

public class CarStack {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        ArrayList<Integer> stack;
        ArrayList<Integer> run;

        int t=input.nextInt();

        for (int i=0;i<t;i++){
            int num= input.nextInt();

            stack=new ArrayList<>();
            run=new ArrayList<>();

            for (int j=0;j<num;j++){
                stack.add(input.nextInt());
            }
            for (int k=0;k<num;k++){
                run.add(input.nextInt());
            }
            if (car(stack,run)) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }
    }
    public static boolean car(ArrayList<Integer> stack, ArrayList<Integer> run){
        int index=0;
        int point=0;
        boolean flag=true;

        while (stack.size()>0){
            if (index>=stack.size()){
                flag=false;
                break;
            }
            int stackItem=stack.get(index);
            int runItem=run.get(point);
            if (stackItem==runItem){
                stack.remove(stack.get(index));

                if (index>0) {
                    index--;
                }

                point++;
            }
            else{
                index++;
            }
        }
        return flag;
    }
}
