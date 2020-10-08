package java.tree;

import java.util.TreeNode;

public class Maximum_depth_of_binary_tree {

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left)+1;
        int right = maxDepth(root.right)+1;
        return left>right?left:right;
    }

}
