package test;

import leetcode.ListNode.ListNode;

public class demo {
    public static void main(String[] args){
        ListNode head = new ListNode(101);
        newList(head, 100);
    }
    public static ListNode newList(ListNode head, int val){
        if(val>0) {
            head.next = new ListNode(val--);
            newList(head.next, val);
            return head;
        }
        return null;
    }
}

