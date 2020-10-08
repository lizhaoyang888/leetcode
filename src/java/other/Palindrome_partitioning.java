package java.other;

import java.util.ArrayList;

public class Palindrome_partitioning {

    public ArrayList<ArrayList<String>> list = new ArrayList<>();

    public ArrayList<ArrayList<String>> partition(String s) {
        help(s,0,new ArrayList<String>());
        return list;
    }

    public void help(String s,int begin,ArrayList<String> res){
        int len = s.length();
        if (begin == len){
            ArrayList<String> temp = (ArrayList<String>)res.clone();
            list.add(temp);
        }
        for (int i=begin+1;i<=len;i++){
            String temp = s.substring(begin,i);
            if (isHuiwen(temp)){
                res.add(temp);
                help(s,i,res);
                res.remove(res.size()-1);
            }
        }
    }
    public boolean isHuiwen(String s){
        int len = s.length();
        if (len == 0 || len == 1){
            return true;
        }
        int left=0,right=len-1;
        while (left <= right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
