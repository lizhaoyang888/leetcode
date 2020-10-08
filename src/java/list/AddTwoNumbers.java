package java.list;

import java.util.ListNode;

/**
 * @Author: lichaoyang
 * @Date: 2020-04-13 22:15
 */

//给定两个代表非负数的链表，数字在链表中是反向存储的（链表头结点处的数字是个位数，第二个结点上的数字是百位数...），求这个两个数的和，结果也用链表表示。
//输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出： 7 -> 0 -> 8

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int temp = 0;
        while (l1 != null || l2 != null || temp != 0){
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                temp += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(temp%10);
            cur = cur.next;
            temp /= 10;
        }
        return head.next;
    }
}
