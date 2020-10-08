package java.list;

import java.util.ListNode;

public class InsertionSortList {

    //建立一个新链表 遍历此链表让源节点插入合适的位置
    public ListNode insertionSortList(ListNode head) {
        ListNode root = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        ListNode pre = root;
        while (cur != null){
            //保存下一节点
            ListNode next = cur.next;
            while (pre.next != null && pre.next.val < cur.val){
                pre = pre.next;
            }
            //插入
            cur.next = pre.next;
            pre.next = cur;
            //处理下一节点
            cur = next;
            pre = root;
        }
        return root.next;
    }
}
