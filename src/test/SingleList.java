package test;

public class SingleList implements List{
    ListNode head = new ListNode(Object.class);
    @Override
    public void insert(int i, Object obj) throws Exception {
        for (ListNode node = head;node != null;node = node.next) {
            if(i<=1){
                ListNode next = node.next;
                node.next = new ListNode(obj);
                node.next.next = next;
            }else {
                i--;
            }
        }
    }

    @Override
    public Object delete(int i) throws Exception {
        for (ListNode node = head;node != null;node = node.next) {
            if(i<=1){
                node.next = node.next.next;
                return true;
            }else {
                i--;
            }
        }
        return false;
    }

    @Override
    public Object getData(int i) throws Exception {
        for (ListNode node = head;node != null;node = node.next) {
            if(i<=1){
                Object obj = node.next.val;
                return obj;
            }else {
                i--;
            }
        }
        return null;
    }

    @Override
    public int size() {
        int num = 0;
        for (ListNode node = head; node != null; node = node.next) {
            num++;
        }
        return num;
    }

    @Override
    public boolean isEmpty() {
        if (head.next == null){
            return false;
        }else{
            return true;
        }
    }
}

class ListNode {
    public Object val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(Object val) {
        this.val = val;
    }

    public ListNode(Object val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
