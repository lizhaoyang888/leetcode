package sort;

import java.util.Arrays;

/**
 * @Author: lichaoyang
 * @Date: 2020-09-14 02:57
 */
public class FindKth {

    public static void main(String[] args) {
        int[] a = {1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
        int[] b = {1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
        Arrays.sort(b);
        System.out.println(b[23]);
        FindKth kth = new FindKth();
        System.out.println(kth.findKth(a,49,24));
    }

    public int findKth(int[] a, int n, int K) {
        // write code here
        return find(a,0,n-1,K);
    }

    public int find(int[] a,int low,int high,int k){
        int pivot = partion(a,low,high);
        if(pivot+1 < k){
            return find(a,pivot+1,high,k);
        }else if(pivot+1 > k){
            return find(a,low,pivot-1,k);
        }else{
            return a[pivot];
        }
    }

    public int partion(int[] a,int start,int end){
        int left = start,right = end;
        int pivotVal = a[start];
        while(left != right){
            while(left < right && a[right] > pivotVal){
                right--;
            }
            while(left < right && a[left] <= pivotVal){
                left++;
            }
            if(left < right){
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
        }
        a[start] = a[left];
        a[left] = pivotVal;
        return left;
    }

}
