package solution;

import datastructure.ListNode;

public class SortList {
    public ListNode sortList(ListNode head){
        ListNode[] countor = new ListNode[64];
        ListNode current = head;
        int maxIndex = 0;
        while (current != null){
            ListNode carryNode = new ListNode(current.val);
            carryNode.next = null;
            current = current.next;
            int i = 0;
            while (countor[i] != null){
                ListNode newHead = mergeList(carryNode, countor[i]);
                countor[i] = null;
                carryNode = newHead;
                i++;
            }
            countor[i] = carryNode;
            if (i > maxIndex){
                maxIndex = i;
            }
        }
        ListNode res = null;
        for (int i = 0; i <= maxIndex; i++){
            if (countor[i] != null){
                res = mergeList(res, countor[i]);
            }
        }
        return res;
    }

    private ListNode mergeList(ListNode list1, ListNode list2) {

        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;

        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                prev.next = list1;
                list1 = list1.next;
            }else{
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 == null ? list2 : list1;
        return prehead.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 8, 2, 7, 6, 5, 4, 3, 1};
        ListNode head = new ListNode(nums);
        SortList solution2 = new SortList();
        ListNode sortList = solution2.sortList(head);
        while (sortList != null){
            System.out.println(sortList.val);
            sortList = sortList.next;
        }
    }
}


