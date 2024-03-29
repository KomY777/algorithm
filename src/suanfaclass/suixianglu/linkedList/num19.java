package suanfaclass.suixianglu.linkedList;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class num19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node  = new ListNode(1);
        node.next=head;
        ListNode fast=node;
        ListNode slow = node;
        while (fast.next != null) {
            if (n > 0) {
                n--;
                fast = fast.next;
                continue;
            }
            slow = slow.next;
            fast = fast.next;
        }
            slow.next = slow.next.next;
        return node.next;
    }
}
