package list;

import util.ListNode;

public class Reorder_list {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        ListNode fast = head,slow = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //拆分并反转链表
        ListNode after = slow.next;
        slow.next = null;
        ListNode pre = null,next=null;
        while (after != null){
            next = after.next;
            after.next = pre;

            pre = after;
            after = next;
        }
        //合并链表
        ListNode first = head,last = pre;
        ListNode ftemp = null,ltemp = null;
        while (first != null && last != null){
            ftemp = first.next;
            ltemp = last.next;

            last.next = first.next;
            first.next = last;

            first = ftemp;
            last = ltemp;
        }
    }
}
