package solution;

import datastructure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class MergekLists {

    public ListNode mergeKLists(ListNode[] lists){
        if (lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        for (ListNode list: lists
             ) {
            if (list != null){
                priorityQueue.add(list);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode point = head;
        while (!priorityQueue.isEmpty()){
            ListNode node = priorityQueue.poll();
            point.next = new ListNode(node.val);
            point = point.next;
            node = node.next;
            if (node != null){
                priorityQueue.add(node);
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        MergekLists mergekLists = new MergekLists();
        ListNode hx = new ListNode(1);
        mergekLists.mergeKLists(new ListNode[]{null, hx});

        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(4);
        h1.next.next = new ListNode(5);

        ListNode h2 = new ListNode(1);
        h2.next = new ListNode(3);
        h2.next.next = new ListNode(4);

        ListNode h3 = new ListNode(2);
        h3.next = new ListNode(6);

        //mergekLists.mergeKLists(new ListNode[]{h1, h2, h3});
    }
}
