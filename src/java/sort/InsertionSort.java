package java.sort;

/**
 * @Author: lichaoyang
 * @Date: 2020-03-13 01:46
 */

/**
 * 插入排序
 */
public class InsertionSort {


    public static void main(String[] args) {
        int[] a = {8,1,3,6,7,9,5,4,2};
        insertSort(a);
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }


    public static void insertSort(int[] a){
        for (int i=1;i<a.length;i++){
            int temp = a[i];
            int j = i;
            while (j>0 && temp < a[j-1]){
                a[j] = a[j-1];
                j--;
            }
            a[j] = temp;
        }
    }
}
