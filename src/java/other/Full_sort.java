package java.other;


import java.util.ArrayList;

public class Full_sort {
    public static void main(String[] args){
        String s = "abcd";
        ArrayList<String> result = new ArrayList<>();
        sort(result,s.toCharArray(),0);
        System.out.println(result);
    }

    public static void sort(ArrayList<String> result,char[] a,int begin){
        int len = a.length;
        if (begin == len-1){
            String temp = String.valueOf(a);
            if (!result.contains(temp)){
                result.add(temp);
            }
        }else {
            for (int j=begin;j<len;j++){
                swap(a,begin,j);
                sort(result,a,begin+1);
                swap(a,begin,j);
            }
        }

    }
    public static void swap(char[] a,int i,int j){
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
