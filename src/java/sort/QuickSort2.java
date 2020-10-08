package java.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: lichaoyang
 * @Date: 2020-06-23 20:45
 */
public class QuickSort2 {

    //指针交换法
    public static void main(String[] args) {
        int[] arr = new int[]{4,7,6,5,3,2,8,1};
        System.out.println(Arrays.toString(arr));
        quickSort2(arr,0,arr.length-1);
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

    //递归能解决的问题大部分都能用栈解决
    public static void quickSort2(int[] arr,int startIndex,int endIndex){

        Stack<Map<String,Integer>> mapStack = new Stack<>();
        Map<String,Integer> rootMap = new HashMap<>();
        rootMap.put("startIndex",startIndex);
        rootMap.put("endIndex",endIndex);
        mapStack.push(rootMap);

        while (!mapStack.isEmpty()){

            Map<String,Integer> param = mapStack.pop();

            //获取基准元素
            int privotIndex = partition(arr, param.get("startIndex"), param.get("endIndex"));

            //privotIndex-1 因为如果左边只有一个元素就不用排了
            if (param.get("startIndex") < privotIndex-1){
                Map<String,Integer> left = new HashMap<>();
                left.put("startIndex",param.get("startIndex"));
                left.put("endIndex",privotIndex-1);
                mapStack.push(left);
            }
            if (param.get("endIndex") > privotIndex+1){
                Map<String,Integer> right = new HashMap<>();
                right.put("startIndex",privotIndex+1);
                right.put("endIndex",param.get("endIndex"));
                mapStack.push(right);
            }
        }
    }

    private static int partition(int[] arr,int startIndex,int endIndex){
        //取第一个元素作为基准元素
        int privot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right){
            while (left < right && arr[right] > privot){
                right--;
            }
            while (left < right && arr[left] <= privot){
                left++;
            }
            if (left < right){
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }
        int temp = arr[left];
        arr[left] = privot;
        arr[startIndex] = temp;
        return left;
    }
}
