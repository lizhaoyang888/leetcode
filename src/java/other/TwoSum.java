package java.other;

/**
 * @Author: lichaoyang
 * @Date: 2020-02-04 10:44
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
 * 假设给出的数组中只存在唯一解
 */
public class TwoSum {

//    public int[] twoSum(int[] numbers, int target) {
//        for (int i=0;i<numbers.length;i++){
//            for (int j=i+1;j<numbers.length;j++){
//                if (numbers[i]+numbers[j]==target){
//                    return new int[]{i+1,j+1};
//                }
//            }
//        }
//        return new int[0];
//    }


    /**
     * 把每次相减后的结果和索引放到map集合中去，我们数组移动下一个数时，我们判断是否存在，如果存在，那么
     * 说明我们找到了这两个数。
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>(numbers.length);
        for (int i=0;i<numbers.length;i++){
            if (map.containsKey(numbers[i])){
                return new int[]{map.get(numbers[i]),i+1};
            }else {
                map.put(target- numbers[i],i+1);
            }
        }
        return new int[0];
    }



    public void out(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] numbers1 = new int[]{0,4,3,0};
        int[] numbers2 = new int[]{3,2,4};
        int target = 0;
        twoSum.out(twoSum.twoSum(numbers1,target));
        twoSum.out(twoSum.twoSum(numbers2,target));
    }

}
