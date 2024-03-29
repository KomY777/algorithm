package leetcode;

import leetcode.ListNode.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 删除链表中和为0的数
 */
public class num1171 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-2);
        head.next.next.next = new ListNode(2);
        ListNode listNode = removeZeroSumSublists(head);
        System.out.println(listNode.toString());
    }

    public static ListNode removeZeroSumSublists(ListNode head) {
//        先创建一个哈希表map,用来存放遍历结点的和与这个结点的位置,其中key为这个结点与前面的和,value为这个结点
//        当遇到有两个存放和一样的结点时,就可以知道这两个结点之间的所有结点的和为0(包括第一个结点但不包括第二个结点),这时通过key存入的新结点会覆盖前面的结点
        Map<Integer, ListNode> map = new HashMap<>();
//        创建一个链表用来存头结点,顺便防止需要删除头结点出现的错误
        ListNode list = new ListNode(0);
        list.next = head;
//        创建一个计数器,用来存放节点的和.
        int sum = 0 ;
//        遍历链表,并将各个链表的和与链表的结点存入map中
        for(ListNode d = list; d != null; d = d.next) {
            sum+= d.val;
            map.put(sum, d);
        }
//        重置计数器,为下一次遍历准备
        sum=0;
//        第二次遍历,将map中存的结点读取出来放到list中
        for(ListNode d = list; d!= null; d = d.next) {
//            这次累加结点的和是为了找到map中的key相等的值,然后按顺序放入
            sum+=d.val;
            d.next=map.get(sum).next;
        }
//        注意,返回时返回的是list的下一个结点.
        return list.next;
    }
}