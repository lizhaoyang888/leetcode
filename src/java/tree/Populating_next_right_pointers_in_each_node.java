package java.tree;

import java.util.TreeLinkNode;

import java.util.LinkedList;

/**
 * 给定二叉树
 * 填充每个指向其右节点的下一个指针。如果没有下一个右节点，下一个指针应该被设置为toNULL。
 * 最初，所有下一个指针都设置为toNULL。
 */
public class Populating_next_right_pointers_in_each_node {

    //层次遍历
    public void connect1(TreeLinkNode root) {
        if(root == null){
            return;
        }
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int length = queue.size();
            for (int i=0;i<length;i++){
                TreeLinkNode node = queue.poll();
                if (i == length-1){
                    node.next = null;
                }else {
                    node.next = queue.peek();
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
    }
    //递归
    public void connect2(TreeLinkNode root) {
        if (root == null){
            return;
        }
        if (root.left != null && root.right != null){
            root.left.next = root.right;
        }
        if (root.next != null && root.right != null){
            root.right.next = root.next.left;
        }
        connect2(root.left);
        connect2(root.right);
    }
    //迭代
    public void connect3(TreeLinkNode root) {
        if (root == null){
            return;
        }
        TreeLinkNode p = root,q;
        while (p.left != null){
            q = p;
            while (q != null){
                if (q.left != null && q.right != null){
                    q.left.next = q.right;
                }
                if (q.next != null && q.right != null){
                    q.right.next = q.next.left;
                }
                q = q.next;
            }
            p = p.left;
        }
    }

    public void connect4(TreeLinkNode root){
        while (root != null){
            //建立每一层的临时头结点
            TreeLinkNode tempLevel = new TreeLinkNode(-1);
            TreeLinkNode cur = tempLevel;
            while (root != null){
                if (root.left != null) {
                    cur.next = root.left;
                    cur = cur.next;
                }
                if (root.right != null){
                    cur.next = root.right;
                    cur = cur.next;
                }
                root = root.next;
            }
            root = tempLevel.next;
        }
    }
}
