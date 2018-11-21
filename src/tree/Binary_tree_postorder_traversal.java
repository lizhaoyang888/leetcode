package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 给定一个二叉树，返回其节点值的后根次序遍历。
 */
public class Binary_tree_postorder_traversal {

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null){
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(0,node.val);//每次插入到头部
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
        return list;
    }

}
