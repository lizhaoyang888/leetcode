package java.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串s和一个单词字典，在s中添加空格来构造一个句子，其中每个单词都是一个有效的字典单词。
 *返回所有这些可能的句子。
 */
public class Word_break_ii {
    public static void main(String[] args){
        Word_break_ii M = new Word_break_ii();
        String s = "catsanddog";
        Set<String> dict = new HashSet<>();
        String[] ch = {"cat","cats","and","sand","dog"};
        //String[] ch = {"d","dd","ddd","dddd"};
        dict.addAll(Arrays.asList(ch));
        System.out.println(M.wordBreak(s,dict));
    }

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<>();
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0){
            return result;
        }
        boolean[] flag = new boolean[s.length()+1];
        help(result,s,dict,"",0,flag);
        return result;
    }
    public void help(ArrayList<String> result,String s,Set<String> dict,String str,
                     int begin,boolean[] flag){
        int len = s.length();
        for (int i = begin+1;i<=len;i++){
            String temp = str;
            String sub = s.substring(begin,i);
            if (dict.contains(sub)){
                if (i == len){
                    result.add(temp+sub);
                }else {
                    if (!flag[i]){
                        int size = result.size();
                        temp += sub+" ";
                        help(result,s,dict,temp,i,flag);
                        if (size == result.size()){
                            flag[i] = true;
                        }
                    }
                }
            }
        }
    }
    
}