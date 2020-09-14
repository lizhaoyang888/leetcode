package tree;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: lichaoyang
 * @Date: 2020-09-07 20:01
 */
public class BinaryTreeTraversal {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        TreeNode temp = treeNode;
        for(int i=1;i<5;i=i+2){
            temp.left = new TreeNode(i);
            temp.right = new TreeNode(i+1);
            temp = temp.left;
        }
        levelTraversal(treeNode);
    }

    public static void preorderTraversal(TreeNode node){
        if (node == null){
            return;
        }
        System.out.println(node.val+" ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public static void preorderTraversal2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()){
            while (node != null){
                System.out.println(node.val);
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()){
                node = stack.pop();
                node = node.right;
            }
        }
    }

    public static void inorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()){
                node = stack.pop();
                System.out.println(node.val);
                node = node.right;
            }
        }
    }

    public static void levelTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = root;
        while (!queue.isEmpty()){
            node = queue.poll();
            System.out.println(node.val);
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
    }

}
