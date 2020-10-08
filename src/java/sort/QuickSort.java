package java.sort;

import java.util.Arrays;

/**
 * @Author: lichaoyang
 * @Date: 2020-06-23 20:45
 */
public class QuickSort {

    //挖坑法
    public static void main(String[] args) {
        int[] arr = new int[]{4,7,6,5,3,2,8,1};
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int startIndex,int endIndex){
        if (startIndex >= endIndex){
            return;
        }
        int privotIndex = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, privotIndex-1);
        quickSort(arr, privotIndex+1, endIndex);
    }

    private static int partition(int[] arr,int startIndex,int endIndex){
        //取第一个元素作为基准元素
        int privot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        //基准元素坑的位置
        int index = startIndex;
        while (right >= left){
            while (right >= left){
                if (arr[right] < privot){
                    arr[left] = arr[right];
                    index = right;
                    left++;
                    break;
                }
                right--;
            }
            while (right >= left){
                if (arr[left] > privot){
                    arr[right] = arr[left];
                    index = left;
                    right--;
                    break;
                }
                left++;
            }
        }
        arr[index] = privot;
        return index;
    }
}
