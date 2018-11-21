package tree;

import util.TreeNode;

public class Symmetric_tree {

    //这颗树是否为镜像树
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return check(root.left,root.right);
    }

    public boolean check(TreeNode x,TreeNode y){
        if (x == null && y == null){
            return true;
        }
        //(p != null && q == null)||(p == null && q != null)
        if (x == null || y == null){
            return false;
        }
        return (x.val == y.val)&&(check(x.left,y.right))&&(check(x.right,y.left));
    }

}
