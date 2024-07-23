package suanfaclass.suixianglu.backtracking;

import java.util.*;

/**
 * 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
 * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
 */
public class num332 {
    static List<List<String>> res = new ArrayList<>();
    static LinkedList<String> path = new LinkedList<>();

    public static void main(String[] args) {
        String[][] array = {
                {"AXA", "EZE"}, {"EZE", "AUA"}, {"ADL", "JFK"}, {"ADL", "TIA"}, {"AUA", "AXA"},
                {"EZE", "TIA"}, {"EZE", "TIA"}, {"AXA", "EZE"}, {"EZE", "ADL"}, {"ANU", "EZE"},
                {"TIA", "EZE"}, {"JFK", "ADL"}, {"AUA", "JFK"}, {"JFK", "EZE"}, {"EZE", "ANU"},
                {"ADL", "AUA"}, {"ANU", "AXA"}, {"AXA", "ADL"}, {"AUA", "JFK"}, {"EZE", "ADL"},
                {"ANU", "TIA"}, {"AUA", "JFK"}, {"TIA", "JFK"}, {"EZE", "AUA"}, {"AXA", "EZE"},
                {"AUA", "ANU"}, {"ADL", "AXA"}, {"EZE", "ADL"}, {"AUA", "ANU"}, {"AXA", "EZE"},
                {"TIA", "AUA"}, {"AXA", "EZE"}, {"AUA", "SYD"}, {"ADL", "JFK"}, {"EZE", "AUA"},
                {"ADL", "ANU"}, {"AUA", "TIA"}, {"ADL", "EZE"}, {"TIA", "JFK"}, {"AXA", "ANU"},
                {"JFK", "AXA"}, {"JFK", "ADL"}, {"ADL", "EZE"}, {"AXA", "TIA"}, {"JFK", "AUA"},
                {"ADL", "EZE"}, {"JFK", "ADL"}, {"ADL", "AXA"}, {"TIA", "AUA"}, {"AXA", "JFK"},
                {"ADL", "AUA"}, {"TIA", "JFK"}, {"JFK", "ADL"}, {"JFK", "ADL"}, {"ANU", "AXA"},
                {"TIA", "AXA"}, {"EZE", "JFK"}, {"EZE", "AXA"}, {"ADL", "TIA"}, {"JFK", "AUA"},
                {"TIA", "EZE"}, {"EZE", "ADL"}, {"JFK", "ANU"}, {"TIA", "AUA"}, {"EZE", "ADL"},
                {"ADL", "JFK"}, {"ANU", "AXA"}, {"AUA", "AXA"}, {"ANU", "EZE"}, {"ADL", "AXA"},
                {"ANU", "AXA"}, {"TIA", "ADL"}, {"JFK", "ADL"}, {"JFK", "TIA"}, {"AUA", "ADL"},
                {"AUA", "TIA"}, {"TIA", "JFK"}, {"EZE", "JFK"}, {"AUA", "ADL"}, {"ADL", "AUA"},
                {"EZE", "ANU"}, {"ADL", "ANU"}, {"AUA", "AXA"}, {"AXA", "TIA"}, {"AXA", "TIA"},
                {"ADL", "AXA"}, {"EZE", "AXA"}, {"AXA", "JFK"}, {"JFK", "AUA"}, {"ANU", "ADL"},
                {"AXA", "TIA"}, {"ANU", "AUA"}, {"JFK", "EZE"}, {"AXA", "ADL"}, {"TIA", "EZE"},
                {"JFK", "AXA"}, {"AXA", "ADL"}, {"EZE", "AUA"}, {"AXA", "ANU"}, {"ADL", "EZE"},
                {"AUA", "EZE"}
        };

        List<List<String>> list = new ArrayList<>();
        for (String[] innerArray : array) {
            list.add(Arrays.asList(innerArray));
        }
        System.out.println(findItinerary(list));
    }
    public static List<String> findItinerary(List<List<String>> tickets) {
        boolean[] used = new boolean[tickets.size()];
        backtracking(tickets, used);
        res.sort(Comparator.comparing(Object::toString));
        return res.get(0);
    }

    public static boolean backtracking(List<List<String>> tickets, boolean[] used) {
        if (path.size() == tickets.size()+1) {
            res.add(new ArrayList<>(path));
            return true;
        }
        int i = 0;
        for (List<String> ticket : tickets) {
            if (used[i]){
                i++;
                continue;
            }
            if (path.isEmpty() && ticket.get(0).equals("JFK")) {
                path.add(ticket.get(0));
                path.add(ticket.get(1));
                used[i] = true;
                backtracking(tickets, used);
                used[i] = false;
                path.removeLast();
                path.removeLast();
            }
            if (!path.isEmpty() && path.getLast().equals(ticket.get(0))) {
                path.add(ticket.get(1));
                used[i] = true;
                if(backtracking(tickets, used)){
                    return true;
                }
                used[i] = false;
                path.removeLast();
            }
            i++;
        }
        return  false;
    }
}
