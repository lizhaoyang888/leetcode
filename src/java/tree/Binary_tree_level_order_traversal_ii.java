package java.tree;

import java.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Binary_tree_level_order_traversal_ii {

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
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
                temp.add(node.val);
            }
            list.add(0,temp);
        }
        return list;
    }

}
