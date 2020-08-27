package other;

import java.util.ArrayList;

/**
 * @Author: lichaoyang
 * @Date: 2020-04-20 18:37
 */

/**
 * 对字符串做全排列
 * ABC -> [ABC, ACB, BAC, BCA, CBA, CAB]
 * 采用回溯
 */
public class PermutationString {

    public static void main(String[] args) {
        System.out.println(permutation("ABC"));
    }

    public static ArrayList<String> permutation(String str){
        char[] arr = str.toCharArray();
        ArrayList<String> list = new ArrayList<String>();
        help(arr,0,list);
        return list;
    }


    public static void help(char[] arr,int i,ArrayList<String> list){
        if (i == arr.length-1){
            String str = String.valueOf(arr);
            if (!list.contains(str)){
                list.add(str);
            }
        }else {
            for (int j=i;j<arr.length;j++){
                swap(arr,i,j);
                help(arr, i+1, list);
                swap(arr,i,j);
            }
        }
    }

    public static void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
