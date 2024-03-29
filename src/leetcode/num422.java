package leetcode;

public class num422 {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(7));
        System.out.println(arrangeCoins2(8));
        System.out.println(arrangeCoins3(9));
    }
//    数学方法
    public static int arrangeCoins(int n) {
        return (int) ((Math.sqrt((long) 8 * n + 1) - 1) / 2);
    }
//    迭代
    public static int arrangeCoins2(int n) {
        for(int i = 1; ; ) {
            if (n >= i) {
                n -= i++;
            } else {
                return i - 1;
            }
        }
    }
// 二分法
    public static int arrangeCoins3(int _n) {
        if (_n == 1){
            return 1;
        }
        int left = 1, right = _n;
        long n = _n;
        while (left < right) {
            int mid = left + (right - left >> 1);
            long s = (long) mid * (mid + 1) / 2;
            if (s < n){
                left = mid + 1;
            }
            else if (s == n){
                return mid;
            } else{
                right = mid;
            }
        }
        return left - 1;
    }

}
