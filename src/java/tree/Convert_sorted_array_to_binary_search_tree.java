package java.tree;

import java.util.ListNode;
import java.util.TreeNode;

/**
 * 给定一个元素按升序排序的数组，将其转换为高度平衡的二叉树。
 */
public class Convert_sorted_array_to_binary_search_tree {

    public TreeNode sortedArrayToBST(int[] num) {
        return help(num,0,num.length);
    }

    public TreeNode help(int[] num,int begin,int end){
        if (begin >= end){
            return null;
        }
        int mid = (begin+end)>>1;
        TreeNode root = new TreeNode(num[mid]);
        root.left = help(num, begin, mid);
        root.right = help(num, mid+1, end);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        return helpBST(head,null);
    }

    public TreeNode helpBST(ListNode head,ListNode tail){
        if (head == tail){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helpBST(head,slow);
        root.right = helpBST(slow.next,tail);
        return root;
    }

}
