package tree;

import util.TreeNode;

/**
 * 给定二叉树，求最大路径和。
 * 路径可以在树中的任何节点开始和结束。
 */
public class Binary_tree_maximum_path_sum {

    public int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        getMaxPathSum(root);
        return maxValue;
    }

    public int getMaxPathSum(TreeNode root){
        if (root == null){
            return 0;
        }
        //和0比较是为了去除负数
        int left = Math.max(0,getMaxPathSum(root.left));
        int right = Math.max(0,getMaxPathSum(root.right));
        //当前节点的子节点的值和自己的值
        maxValue = Math.max(maxValue,left+right+root.val);
        //返回值是当前节点和左右子节点的较大者的和值
        return Math.max(0,Math.max(left,right)+root.val);
    }

}
