package java.sort;

import java.util.Arrays;

/**
 * @Author: lichaoyang
 * @Date: 2020-09-15 10:59
 */
public class QuickSort4 {

    public static void main(String[] args) {
        int[] arr = new int[]{4,7,6,5,3,5,8,1};
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

//    public static int partion(int[] a,int left,int right){
//        int pivotVal = a[left];
//        int index = left;
//        while (left < right){
//            while (left < right){
//                if (a[right] < pivotVal){
//                    a[index] = a[right];
//                    index = right;
//                    break;
//                }
//                right--;
//            }
//            while (left < right){
//                if (a[left] > pivotVal){
//                    a[index] = a[left];
//                    index = left;
//                    break;
//                }
//                left++;
//            }
//        }
//        a[index] = pivotVal;
//        return index;
//    }



    public static int partion(int[] a,int left,int right){
        int pivotVal = a[left];
        int index = left;
        while (left < right){
            while (left < right){
                if (a[right] < pivotVal){
                    a[index] = a[right];
                    index = right;
                    break;
                }
                right--;
            }
            while (left < right){
                if (a[left] > pivotVal){
                    a[index] = a[left];
                    index = left;
                    break;
                }
                left++;
            }
        }
        a[index] = pivotVal;
        return index;
    }
}
