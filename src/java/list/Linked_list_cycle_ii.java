package java.list;

import java.util.ListNode;

/**
 * 给定一个链表，返回循环开始的节点。如果没有循环，返回null。
 */
public class Linked_list_cycle_ii {
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode slow = null,fast = null;
        if (head.next != null && head.next.next != null) {
            slow = head.next;
            fast = head.next.next;
        }else {
            return null;
        }
        while (slow != fast){
            if (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }else {
                return null;
            }
        }
        ListNode cur = head;
        while (cur != slow){
            cur = cur.next;
            slow = slow.next;
        }
        return cur;
    }
}
