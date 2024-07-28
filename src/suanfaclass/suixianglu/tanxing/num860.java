package suanfaclass.suixianglu.tanxing;

/**
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 */
public class num860 {
    public static void main(String[] args) {
        System.out.println(15 / 10);
    }

    public boolean lemonadeChange(int[] bills) {
        int[] earn = new int[2];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                earn[0]++;
            } else if (bills[i] == 10) {
                if (earn[0] <= 0) return false;
                earn[1]++;
                earn[0]--;
            } else {
                if (earn[1] > 0 && earn[0] > 0) {
                    earn[0]--;
                    earn[1]--;
                } else if (earn[0] >= 3) {
                    earn[0] -= 3;
                } else {
                    return false;
                }
            }

        }
        return true;
    }
}
}
