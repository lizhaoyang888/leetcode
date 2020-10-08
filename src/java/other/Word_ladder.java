package java.other;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 给定两个单词(start和end)和一个字典，求从开始到结束的最短变换序列的长度
 */
public class Word_ladder {

    public static void main(String[] args){
        Word_ladder mm = new Word_ladder();
        String start = "hot",end = "git";
        HashSet<String> dict = new HashSet<>();
        dict.add("hit");dict.add("dog");
        System.out.println(mm.ladderLength(start,end,dict));
    }

    //采用广度遍历
    public int ladderLength(String start, String end, HashSet<String> dict) {
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(start);
        int sum=1;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                String temp = queue.poll();
                size--;
                if (isDiffOne(temp,end)){
                    return sum+1;
                }
                Iterator iterator = dict.iterator();
                while (iterator.hasNext()){
                    String it = (String)iterator.next();
                    if (isDiffOne(temp,it)){
                        queue.offer(it);
                        iterator.remove();
                    }
                }
            }
            sum++;
        }
        return 0;
    }

    public boolean isDiffOne(String s,String t){
        int count=0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) != t.charAt(i)){
                count++;
            }
            if (count > 1){
                return false;
            }
        }
        return true;
    }

}
