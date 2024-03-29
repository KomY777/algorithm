package suanfaclass.suixianglu.linkedList;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 */
public class num160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA=headA,curB=headB;
        int lenA=0,lenB=0;
        while (curA!=null){
            lenA++;
            curA=curA.next;
        }
        while (curB!=null){
            lenB++;
            curB=curB.next;
        }
        curA = headA;
        curB = headB;
        if (lenB>lenA){
            int templen = lenA;
            lenA=lenB;
            lenB=templen;
            ListNode tempNode=curA;
            curA=curB;
            curB=tempNode;
        }
        int gap = lenA-lenB;
        while(gap-- >0){
            curA=curA.next;
        }
        while (curA!=null){
            if (curA==curB){
                return curA;
            }
            curA=curA.next;
            curB=curB.next;
        }
        return null;
    }
}
