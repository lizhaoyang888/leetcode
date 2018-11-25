package list;

import util.ListNode;

public class Partition_list {

    public static ListNode partition(ListNode head, int x) {
        ListNode M = new ListNode(-1);
        ListNode N = new ListNode(-1);
        ListNode pre = M,next = N;
        while (head != null){
            if (head.val < x){
                pre.next = head;
                pre = pre.next;
            }else {
                next.next = head;
                next = next.next;
            }
            head = head.next;
        }
        pre.next = N.next;
        //这一句很关键  斩断后面的 不然会形成死循环
        next.next = null;
        return M.next;
    }

}
