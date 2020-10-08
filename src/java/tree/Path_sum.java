package java.tree;

import java.util.TreeNode;

import java.util.ArrayList;

public class Path_sum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum){
            return true;
        }
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }

    public void help(TreeNode root, int sum, ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> list){
        if (root == null){
            return;
        }
        temp.add(root.val);
        if (root.left == null && root.right == null && root.val == sum){
            ArrayList<Integer> ret = (ArrayList<Integer>) temp.clone();
            list.add(ret);
        }
        help(root.left, sum-root.val, temp, list);
        help(root.right,sum-root.val,temp,list);
        temp.remove(temp.size()-1);
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        help(root,sum,temp, list);

        return list;
    }

}
