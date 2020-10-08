package java.sort;

import java.util.Arrays;

public class HeapSort2 {


    public static void main(String[] args) {
        int[] arr = new int[]{4,7,6,5,3,2,8,1};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] array){
        for(int i=array.length-1;i>=0;i--){
            downAjust(array,i,array.length);
        }
        int temp = 0;
        for (int i=array.length-1;i>=0;i--){
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            downAjust(array,0,i);
        }
    }

    public static void downAjust(int[] array,int parentIdex,int length){
        int temp = array[parentIdex];
        int childIndex = 2 * parentIdex + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex] < array[childIndex + 1]) {
                childIndex++;
            }
            if (temp >= array[childIndex]) {
                break;
            }
            array[parentIdex] = array[childIndex];
            parentIdex = childIndex;
            childIndex = 2 * parentIdex + 1;
        }
        array[parentIdex] = temp;
    }
}
