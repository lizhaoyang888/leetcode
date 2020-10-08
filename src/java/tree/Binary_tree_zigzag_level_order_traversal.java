package java.tree;

import java.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Binary_tree_zigzag_level_order_traversal {
    //按层蛇形打印二叉树
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                if (flag) {
                    temp.add(node.val);
                }else {
                    temp.add(0,node.val);
                }
            }
            list.add(temp);
            flag = !flag;
        }
        return list;
    }

}
