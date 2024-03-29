package suanfaclass.suixianglu.linkedList;

public class num709 {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
        int i = myLinkedList.get(1);// 返回 2
        myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
        int i1 = myLinkedList.get(1);// 返回 3
        System.out.println(i1);
    }
    static class MyLinkedList {
        int val;
        MyLinkedList next;
        MyLinkedList prev;

        public MyLinkedList() {

        }

        public int get(int index) {
            MyLinkedList node = this;
            while (node.prev!= null){
                node = node.prev;
            }
            for (int i = 0; i < index; i++){
                node = node.next;
                if (node == null){
                    return -1;
                }
            }
            return node.val;
        }

        public void addAtHead(int val) {
            MyLinkedList node = this;
            while (node.prev!= null){
                node = node.prev;
            }
            MyLinkedList newNode = new MyLinkedList();
            newNode.val = val;
            newNode.next = node;
            node.prev = newNode;
        }

        public void addAtTail(int val) {
            MyLinkedList node = this;
            while (node.next!= null){
                node = node.next;
            }
            MyLinkedList newNode = new MyLinkedList();
            newNode.val = val;
            newNode.prev = node;
            node.next = newNode;
        }

        public void addAtIndex(int index, int val) {
            MyLinkedList node = this;
            while (node.prev!= null){
                node = node.prev;
            }
            for (int i = 0; i < index; i++){
                node = node.next;
                if (node == null){
                    return;
                }
            }
            MyLinkedList preNode = node.prev;
            MyLinkedList newNode = new MyLinkedList();
            newNode.val = val;
            newNode.next = node;
            newNode.prev = preNode;
            node.prev = newNode;
            preNode.next=newNode;
        }

        public void deleteAtIndex(int index) {
            MyLinkedList node = this;
            while (node.prev!= null){
                node = node.prev;
            }
            for (int i = 0; i < index; i++){
                node = node.next;
                if (node == null){
                    return;
                }
            }
            MyLinkedList preNode = node.prev;
            MyLinkedList nextNode = node.next;
            preNode.next = nextNode;
            nextNode.prev = preNode;
        }
    }

}
