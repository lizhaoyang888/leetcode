package list;

import util.ListNode;

public class Reorder_list {

    /**
     * 将给定的单链表L： L 0→L 1→…→L n-1→L n,
     * 重新排序为： L 0→L n →L 1→L n-1→L 2→L n-2→…
     * @param head
     */
    public static void reorderList(ListNode head) {
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
        while (last != null){
            ftemp = first.next;
            ltemp = last.next;

            last.next = first.next;
            first.next = last;

            first = ftemp;
            last = ltemp;
        }
    }

    public static void main(String[] args) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for(int i=1;i<50;i++){
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = cur.next;
        }
        reorderList(dummy.next);
        cur = dummy.next;
        while (cur != null){
            System.out.print(cur.val+"->");
            cur = cur.next;
        }
    }
}
