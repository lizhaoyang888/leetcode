package java.other;

import java.util.ArrayList;
import java.util.Arrays;

//给定一组不同的整数，S，返回所有可能的子集。
public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (S == null || S.length == 0){
            return list;
        }
        Arrays.sort(S);
        ArrayList<Integer> temp = new ArrayList<>();
        //因为结果集是按size排序的 所以在这遍历size
        for (int i=0;i<=S.length;i++){
            dfs(S,0,i,list,temp);
        }
        return list;
    }
    private void dfs(int[] S,int start,int size,ArrayList<ArrayList<Integer>> list,ArrayList temp){
        if (size < 0){
            return;
        }else if (size == 0){
            list.add(new ArrayList<>(temp));
        }
        for (int i=start;i<S.length;i++){
            temp.add(S[i]);
            dfs(S, i+1,size-1,list,temp);
            temp.remove(temp.size()-1);
        }
    }
}
