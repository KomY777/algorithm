package suanfaclass.suixianglu.doublezhizhen;

import leetcode.ListNode.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class num206 {
    public ListNode reverseList(ListNode head) {
        ListNode temp;
        ListNode node=head;
        ListNode pre=null;
        while (node!=null){
            temp= node.next;
            node.next=pre;
            pre= node;
            node=temp;
        }
        return pre;
    }
}
