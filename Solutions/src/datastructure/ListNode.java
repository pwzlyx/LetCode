package datastructure;


public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {this.val = x;}

    public void add(ListNode head, int x){
        ListNode p = head;
        if (head == null){
            head = new ListNode(x);
            head.next = null;
        }else{
            while (p.next != null){
                p = p.next;
            }
            p.next = new ListNode(x);
        }
    }

    public ListNode(int[] x) {
       this.val = x[0];
       ListNode p = this;
       for (int i = 1; i < x.length; i++){
           p.next = new ListNode(x[i]);
           p = p.next;
       }
       p.next = null;
    }
}
