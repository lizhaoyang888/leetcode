package java.other;

import java.util.*;

public class Word_ladder_ii {

    public ArrayList<ArrayList<String>> list = new ArrayList<>();

    public static void main(String[] args){
        Word_ladder_ii mm = new Word_ladder_ii();
        String start = "hht",end = "got";
        HashSet<String> dict = new HashSet<>();
        dict.add("hit");dict.add("hat");dict.add("git");dict.add("gat");
        System.out.println(mm.findLadders(start,end,dict));
    }

    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict){
        Iterator iterator = dict.iterator();
        ArrayList<String> dd = new ArrayList<>();
        while (iterator.hasNext()){
            String temp = (String)iterator.next();
            dd.add(temp);
        }
        ArrayList<String> res = new ArrayList<>();
        res.add(start);
        offer(start,end,dd,res);
        return list;
    }

    public void offer(String start,String end,ArrayList<String> dict,ArrayList<String> res){
        if (isDiffOne(start, end)) {
            res.add(end);
            ArrayList<String> temp = (ArrayList<String>)res.clone();
            if (!list.contains(temp)) {
                list.add(temp);
            }
            res.remove(res.size()-1);
            return;
        }
        for (int i=0;i<dict.size();i++){
            String str = dict.get(i);
            if (isDiffOne(start,str)){
                res.add(str);
                dict.remove(i);
                offer(str, end, dict, res);
                dict.add(str);
                res.remove(res.size()-1);
            }
        }
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
