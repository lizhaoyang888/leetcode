package tree;

import util.TreeNode;


public class Sum_root_to_leaf_numbers {

    public int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }
        return preorderSum(root,0);
    }

    //先序遍历
    public int preorderSum(TreeNode root,int sum){
        if (root == null){
            return 0;
        }
        sum = sum*10 + root.val;
        if (root.left == null && root.right == null){
            return sum;
        }
        return preorderSum(root.left, sum)+preorderSum(root.right, sum);
    }

}
