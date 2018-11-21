package other;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 给定一个未排序的整数数组，查找最长连续元素序列的长度。
 * 例如,
 * 给定[100,4,200,1,3,2]，
 * 最长的连续元素序列为[1,2,3,4]。返回其长度:4。
 * 你的算法应该以O(n)的复杂度运行。
 */
public class Longest_consecutive_sequence {

    public int longestConsecutive(int[] num) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        for (int i=0;i<num.length;i++){
            map.put(num[i],false);
        }
        Iterator iterator = map.keySet().iterator();
        int max = -1,count=0;
        while (max < map.size()/2 && iterator.hasNext()){
            int n = (int) iterator.next();
            //已经访问过
            if (map.get(n)){
                continue;
            }
            //访问比它小的
            int left = n;
            while (map.containsKey(left)){
                map.put(left,true);
                count++;
                left = left-1;
            }
            //访问比它大的
            int right = n+1;
            while (map.containsKey(right)){
                map.put(right,true);
                count++;
                right = right+1;
            }
            max = max < count?count:max;
            count = 0;
        }
        return max;
    }
}
