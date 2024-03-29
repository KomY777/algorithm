package suanfaclass.suixianglu.linkedList;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class num26 {
    public ListNode swapPairs(ListNode head) {
        ListNode temp;
        ListNode node=new ListNode(0);
        node.next=head;
        ListNode dump=node;
        ListNode firstNode=null;
        ListNode secondNode=null;
        while(dump.next!=null &&dump.next.next!=null){
            temp = dump.next.next.next;
            firstNode=dump.next;
            secondNode=dump.next.next;
            dump.next=secondNode;
            secondNode.next=firstNode;
            firstNode.next=temp;
            dump=firstNode;
        }
        return node.next;
    }
}
