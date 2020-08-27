package list;

/**
 * @Author: lichaoyang
 * @Date: 2020-02-05 16:21
 */

import util.ListNode;

/**
 * 将给出的链表中的节点每k个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是k的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * 只允许使用常数级的空间
 */
public class ReverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        int count;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode after = head;
        ListNode cur = head;
        ListNode temp,pre=dummy;
        while (true){
            count = k;
            while (count>0 && after != null){
                count--;
                after = after.next;
            }
            if (after == null){
                break;
            }
            while (cur != after){
                temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
        }
        return dummy.next;
    }

    public static void out(ListNode head){
        while (head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;
        int k = 3;
        out(reverseKGroup(one,k));
    }

//    public static ListNode reverseKGroup(ListNode head, int k) {
//        if(head == null || head.next == null || k < 2) return head;
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode pre = dummy, cur = head, temp;
//        int len = 0;
//        while (head != null) {
//            len ++ ;
//            head = head.next;
//        }
//        for (int i = 0; i < len / k; i ++ ) {
//            for (int j = 1; j < k; j ++ ) {
//                temp = cur.next;
//                cur.next = temp.next;
//                temp.next = pre.next;
//                pre.next = temp;
//            }
//            pre = cur;
//            cur = cur.next;
//        }
//        return dummy.next;
//    }

}
