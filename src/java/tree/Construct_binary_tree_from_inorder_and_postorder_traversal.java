package java.tree;

import java.util.TreeNode;

public class Construct_binary_tree_from_inorder_and_postorder_traversal {

    //知道中序和后序遍历 构造二叉树
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    public TreeNode buildTree(int[] inorder,int inLeft,int inRight,int[] postorder,int postLeft,int postRight){
        if (postLeft > postRight){
            return null;
        }
        TreeNode node = new TreeNode(postorder[postRight]);
        if (postLeft == postRight){
            return node;
        }
        int num=inLeft;
        for (int i=inLeft;i<=inRight;i++){
            if (inorder[i] == postorder[postRight]){
                num = i;
                break;
            }
        }
        int len = num-inLeft;
        node.left = buildTree(inorder, inLeft, num-1, postorder, postLeft, postLeft+len-1);
        node.right = buildTree(inorder, num+1, inRight, postorder, postLeft+len, postRight-1);
        return node;
    }

}
