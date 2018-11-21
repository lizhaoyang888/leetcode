package tree;

import util.TreeNode;

public class Same_tree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        //(p != null && q == null)||(p == null && q != null)
        if (q == null || p == null){
            return false;
        }
        return (p.val == q.val)&&(isSameTree(p.left,q.left))&&(isSameTree(p.right,q.right));
    }

}
