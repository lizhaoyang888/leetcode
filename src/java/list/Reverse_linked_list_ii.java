package java.list;

import java.util.ListNode;

public class Reverse_linked_list_ii {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        //设定一个头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start = head;
        ListNode preStart = dummy;
        for (int i=1;i<m;i++){
            preStart = start;
            start = start.next;
        }
        //颠倒顺序就如
        //A B C D
        //B A C D
        //C B A D
        //D C B A
        for (int i=0;i<n-m;i++){
            ListNode temp = start.next;
            start.next = temp.next;
            temp.next = preStart.next;
            preStart.next = temp;
        }
        return dummy.next;
    }

}
