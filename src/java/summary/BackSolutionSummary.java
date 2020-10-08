package summary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2020-06-30 11:20
 */
public class BackSolutionSummary {

    /**
     * 回到backTrace函数，其实就是一个选择/撤销选择的过程，其中的for循环也是一个选择的过程，还有一个点就是base case需要在这个函数来处理。那么，我们就可以把框架整理出来。
     *     public void backTrace(int start, int[] nums, List<Integer> temp){
     *         base case处理
     *         //选择过程
     *         for(循环选择){
     *             选择
     *             backTrace(递归);
     *             撤销选择
     *         }
     *     }
     *
     * 作者：欧阳思海
     * 链接：https://juejin.im/post/5ef7fb805188252e612bef19
     * 来源：掘金
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param start
     * @param nums
     * @param temp
     */

    private static List<List<Integer>> list = new ArrayList<>();

    //子集问题,存在重复子集  [1, 2]=>{[], [1], [1, 2], [2]}
    public static List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        List<Integer> temp = new ArrayList<>();
        backTrace(0,nums,temp);
        return list;
    }

    private static void backTrace(int start, int[] nums, List<Integer> temp){
        list.add(new ArrayList<>(temp));
        for (int i = start;i<nums.length;i++){
            temp.add(nums[i]);
            backTrace(i+1,nums,temp);
            temp.remove(temp.size()-1);
        }
    }

    //去重复子集  [1, 2, 2, 5, 5]
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        //避免元素一样，但是顺序不一样的重复子集问题。
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        backTraceWithDup(0,nums,temp);
        return list;
    }

    private static void backTraceWithDup(int start, int[] nums, List<Integer> temp){
        list.add(new ArrayList<>(temp));
        for (int i = start;i<nums.length;i++){
            //剪枝策略 同一层只保留第一个相同的元素 后面相同的元素全部剪枝
            if (i > start && nums[i] == nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            backTraceWithDup(i+1,nums,temp);
            temp.remove(temp.size()-1);
        }
    }

    //组合总和问题
    //给一个无重复数字的数组 和 target 返回数组中和为target的集合 每个数字可以被无限制重复被选取
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target < 0 || candidates.length == 0){
            return list;
        }
        List<Integer> temp = new ArrayList<>();
        backTrace(0,candidates,target,temp);
        return list;
    }

    public static void backTrace(int start, int[] candidates, int target, List<Integer> temp){
        if (target < 0){
            return;
        }
        if (target == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i=start;i<candidates.length;i++){
            temp.add(candidates[i]);
            //每个数字可以被无限制重复被选取，我们要做的就是在递归的时候，i的下标不是从i+1开始，而是从i开始
            backTrace(i,candidates,target-candidates[i],temp);
            temp.remove(temp.size()-1);
        }
    }


    //组合总和问题
    //所有数字智能使用一次 解集不能包含重复的组合
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (target < 0 || candidates.length == 0){
            return list;
        }
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        backTrace2(0,candidates,target,temp);
        return list;
    }

    public static void backTrace2(int start, int[] candidates, int target, List<Integer> temp){
        if (target < 0){
            return;
        }
        if (target == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i=start;i<candidates.length;i++){
            if (i > start && candidates[i] == candidates[i-1]){
                continue;
            }
            temp.add(candidates[i]);
            backTrace2(i+1,candidates,target-candidates[i],temp);
            temp.remove(temp.size()-1);
        }
    }

    //全排列
    //给定一组不重复的数字 返回所有的组合
    public static List<List<Integer>> permute(int[] nums) {
        backTrace(nums,0);
        return list;
    }

    public static void backTrace(int[] nums, int start){
        if(start == nums.length-1){
            list.add(switchArray(nums));
            return;
        }
        for (int i = start;i<nums.length;i++){
            swap(nums,start,i);
            backTrace(nums, start+1);
            swap(nums,start,i);
        }
    }

    private static void swap(int[] num,int i,int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    private static ArrayList<Integer> switchArray(int[] num){
        ArrayList<Integer> arrayList = new ArrayList<>(num.length);
        for (int i=0;i<num.length;i++){
            arrayList.add(num[i]);
        }
        return arrayList;
    }

    /**
     * 给定一个包含n个整数的数组num和一个目标值target，找出num中三个整数 ，使得他们的和与target最相近，返回三个数字的和
     * @param num
     * @param target
     * @return
     */
    public static int threeSumCloset(int[] num,int target){
        if (num == null || num.length == 0){
            return 0;
        }
        Arrays.sort(num);
        int res = num[0]+num[1]+num[2];
        for (int i=0;i<num.length;i++){
            int t1 = i+1;
            int t2 = num.length-1;
            while (t1 < t2){
                int cur = num[i]+num[t1]+num[t2];
                if (Math.abs(cur-target) < Math.abs(res-target)){
                    res = cur;
                }
                if (cur < target){
                    t1++;
                }else {
                    t2--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,3,5,7,9};
        permute(nums);
        System.out.println(list);
        System.out.println(threeSumCloset(nums,19));
    }

}
