package 新建文件夹;

public class StackOut {
    public static void main(String[] args) {
        for (int i = 1; i <=7; i++) {
            System.out.println("n为"+i+"时"+"个数为： "+Judge(i));
        }
    }
    public static int Judge(int n){
        if (n==1){
            return 1;
        }
        int n1 = 1,n2=1;
        for (int i = 1  ; i <= n ; i ++) {
            n1 *=i;
        }
        for (int i = 1; i <= n/2;i++ ){
            n2 *=i;
        }
        return (n1/n2)/(n+1);
    }
}
