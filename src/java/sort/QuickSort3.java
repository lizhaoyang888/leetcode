package java.sort;

import java.util.Arrays;

/**
 * @Author: lichaoyang
 * @Date: 2020-09-10 19:35
 */
public class QuickSort3 {


    public static void main(String[] args) {
        int[] arr = new int[]{4,7,6,5,3,2,8,1};
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] array, int start,int end){
        if (start >= end){
            return;
        }
        int part = partion(array, start, end);
        quickSort(array,start,part-1);
        quickSort(array, part+1, end);
    }

    public static int partion(int[] array,int start,int end){
        int temp = array[start];
        int left = start;
        int right = end;
        while (left != right){
            while (left < right && array[right] > temp){
                right--;
            }
            while (left < right && array[left] <= temp){
                left++;
            }
            if (left < right){
                int val = array[left];
                array[left] = array[right];
                array[right] = val;
            }
        }
        int kk = array[left];
        array[left] = temp;
        array[start] = kk;
        return left;
    }
}
