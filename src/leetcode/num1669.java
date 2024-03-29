package leetcode;

import leetcode.ListNode.ListNode;

/**
 * 合并两个链表
 */
public class num1669 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        ListNode node = mergeInBetween(head1, 1, 2, head2);
        System.out.println(node.toString());
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
//        先创建一个链表list来存放list1，为后续遍历做准备,也先创建一个头结点,防止后续出错.
        ListNode list = new ListNode();
        list.next = list1;
//        创建一个计数器记录链表的位置
        int num = 0;
//        遍历list1中的元素，并找到要删除的最后一个数，然后将这个结点的下一个结点接到list2的后面。
        while (true) {
            list1=list1.next;
//           当计数器num的值和b相等时就找到了要删除的最后一个数
            if (num == b) {
//                开始遍历list2,找到list2的最后一个结点
                for (ListNode node2 = list2; node2 != null; node2 = node2.next) {
//                    找到最后一个结点了,将最后一个结点的下一个结点分配给list1找到删除结点后的剩余的结点
                    if (node2.next == null) {
                        node2.next = list1;
                        break;
                    }
                }
                break;
            }
            num++;
        }
//        重新定义计数器,做下一轮遍历.
//        这一轮遍历是将链表list2放到最开始定义的链表list中,要删除的第一个结点的前驱结点的后面
        num = 0;
        for (ListNode node = list; node.next != null; node = node.next) {
//            通过计数器找到要删除结点的位置
            if (num == a) {
//                将list2直接放到这个结点后面
                node.next = list2;
                break;
            }
            num++;
        }
//        注意返回的是list的下一个结点
        return list.next;
    }
}
