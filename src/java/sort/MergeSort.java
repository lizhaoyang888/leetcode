package java.sort;

import java.util.Arrays;

/**
 * @Author: lichaoyang
 * @Date: 2020-06-28 20:14
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4,7,6,5,3,2,8,1};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr,int start,int end){
        if (start<end){
            int mid = (start+end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr,start,mid,end);
        }
    }

    public static void merge(int[] arr,int start,int mid,int end){
        int[] temp = new int[end-start+1];
        int p = start,q = mid+1,index=0;
        while (p <= mid && q <= end){
            if (arr[p] < arr[q]){
                temp[index++] = arr[p++];
            }else {
                temp[index++] = arr[q++];
            }
        }
        while (p <= mid){
            temp[index++] = arr[p++];
        }
        while (q <= end){
            temp[index++] = arr[q++];
        }
        for (int i=0;i<temp.length;i++){
            arr[start+i] = temp[i];
        }
    }
}
