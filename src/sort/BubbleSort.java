package sort;

import java.util.Arrays;

/**
 * @Author: lichaoyang
 * @Date: 2020-08-27 11:07
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        int temp = 0;
        boolean sorted = true;
        int lastExchange = 0;
        int sortIndex = arr.length-1;
        for(int i=0;i<arr.length;i++){
            for (int j=0;j<sortIndex;j++){
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    sorted = false;
                    lastExchange = j;
                }
            }
            sortIndex = lastExchange;
            if (sorted){
                break;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {4,7,5,9,8,6,2,1,3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
