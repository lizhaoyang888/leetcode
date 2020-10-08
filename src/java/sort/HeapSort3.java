package java.sort;

import java.util.Arrays;

/**
 * @Author: lichaoyang
 * @Date: 2020-09-20 09:01
 */
public class HeapSort3 {


    public static void main(String[] args) {
        int[] arr = new int[]{4,7,6,5,3,2,8,1};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] a){
        for (int i = a.length/2;i>=0;i--){
            downAjust(a,i,a.length);
        }
        for (int j=a.length-1;j>=0;j--){
            int temp = a[j];
            a[j] = a[0];
            a[0] = temp;
            downAjust(a,0,j);
        }
    }

    public static void downAjust(int[] a,int parentIndex,int length){
        int temp = a[parentIndex];
        int childIndex = 2*parentIndex+1;
        while (childIndex < length){
            if (childIndex+1 < length && a[childIndex] < a[childIndex+1]){
                childIndex++;
            }
            if (temp > a[childIndex]){
                break;
            }
            a[parentIndex] = a[childIndex];
            parentIndex = childIndex;
            childIndex = 2*parentIndex+1;
        }
        a[parentIndex] = temp;
    }
}
