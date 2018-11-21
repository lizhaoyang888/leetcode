package other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串s和一个单词字典，在s中添加空格来构造一个句子，其中每个单词都是一个有效的字典单词。
 */
public class Word_break {
    public static void main(String[] args){
        Word_break M = new Word_break();
        String s = "catsanddog";
        Set<String> dict = new HashSet<>();
        String[] ch = {"cat","cats","and","sand","dog"};
        //String[] ch = {"d","dd","ddd","dddd"};
        dict.addAll(Arrays.asList(ch));
        System.out.println(M.wordBreak(s,dict));
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0){
            return false;
        }
        boolean[] flag = new boolean[s.length()+1];
        return help(s,dict,0,flag);
    }
    public boolean help(String s,Set<String> dict,int begin,boolean[] flag){
        int len = s.length();
        for (int i = begin+1;i<=len;i++){
            String sub = s.substring(begin,i);
            if (dict.contains(sub)){
                if (i == len){
                    return true;
                }else {
                    if (!flag[i]){
                        if (!help(s,dict,i,flag)){
                            flag[i] = true;
                        }else {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
}