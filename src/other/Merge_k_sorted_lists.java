package other;

import util.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Merge_k_sorted_lists {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for (ListNode listNode:lists){
            if (listNode != null) {
                queue.add(listNode);
            }
        }
        while (!queue.isEmpty()){
            ListNode listNode = queue.poll();
            tail.next = listNode;
            tail = tail.next;
            if (tail.next != null){
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }

}
