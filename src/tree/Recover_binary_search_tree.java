package tree;

import util.TreeNode;

/**
 * 二叉搜索树(BST)的两个元素错误地交换了。
 * 在不改变树结构的情况下恢复树。
 */
public class Recover_binary_search_tree {

    public TreeNode pre = null,firstErrorNode = null,secondErrorNode = null;

    public void recoverTree(TreeNode root) {
        dfs(root);
        int temp = firstErrorNode.val;
        firstErrorNode.val = secondErrorNode.val;
        secondErrorNode.val = temp;
    }

    //中序遍历二叉树 就是升序排列
    //如果前节点比后节点值大 则前节点就是第一处错误节点
    //如果后节点的值比前节点小 则此后节点就是第二处错误
    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        dfs(root.left);
        if (pre != null && pre.val >= root.val){
            if (firstErrorNode == null){
                firstErrorNode = pre;
            }
            secondErrorNode = root;
        }
        pre = root;
        dfs(root.right);
    }

    //判断是否为二叉搜索树
    public boolean isValidBST(TreeNode root) {
        return isValidRoot(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean isValidRoot(TreeNode root,int lower,int upper){
        if (root == null){
            return true;
        }
        if (root.val <= lower || root.val >= upper){
            return false;
        }
        return isValidRoot(root.left,lower,root.val)&&isValidRoot(root.right, root.val, upper);
    }

}
