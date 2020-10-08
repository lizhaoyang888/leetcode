package java.sort;

/**
 * @Author: lichaoyang
 * @Date: 2020-03-13 01:24
 */

/**
 * 选择排序
 */
public class SelectionSort {


    public static void main(String[] args) {
        int[] a = {8,1,3,6,7,9,5,4,2};
        selectSort(a);
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }


    public static void selectSort(int[] a){
        int index = 0;
        for (int i=0;i<a.length;i++){
            index = i;
            for (int j=i+1;j<a.length;j++){
                if (a[index] > a[j]){
                    index = j;
                }
            }
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
    }
}
