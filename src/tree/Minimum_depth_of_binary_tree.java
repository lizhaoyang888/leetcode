package tree;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定二叉树，求它的最小深度。最小深度是根节点到最近的叶节点的最短路径上的节点数。
 */

public class Minimum_depth_of_binary_tree {

    public int run(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 0;
        int nextVal = queue.size();
        int depth = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            index++;
            if (node.left == null && node.right == null){
                return depth;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (nextVal == index){
                depth++;
                index = 0;
                nextVal = queue.size();
            }
        }
        return 0;
    }
}
