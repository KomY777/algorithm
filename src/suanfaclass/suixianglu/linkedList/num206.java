package suanfaclass.suixianglu.linkedList;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 */
public class num206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp;
        while (head != null) {
            temp = head.next;// 保存下一个节点
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
