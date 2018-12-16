package list;

import util.ListNode;

public class Merge_two_sorted_lists {

    public ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                cur.next = n1;
                n1 = n1.next;
            } else {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;
        }
        if (n1 == null){
            cur.next = n2;
        }else {
            cur.next = n1;
        }
        return head.next;
    }

}
