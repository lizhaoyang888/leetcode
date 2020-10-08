package java.tree;

import java.util.TreeNode;

public class Construct_binary_tree_from_preorder_and_inorder_traversal {

    //知道前序和中序遍历 构造二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder,int preLeft,int preRight,int[] inorder,int inLeft,int inRight){
        if (preLeft > preRight){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preLeft]);
        if (preLeft == preRight){
            return node;
        }
        int num = inLeft;
        for (int i=inLeft;i<=inRight;i++){
            if (preorder[preLeft] == inorder[i]){
                num = i;
                break;
            }
        }
        int len = num-inLeft;
        node.left = buildTree(preorder, preLeft+1, preLeft+len, inorder, inLeft, num-1);
        node.right = buildTree(preorder, preLeft+len+1, preRight, inorder, num+1, inRight);
        return node;
    }

}
