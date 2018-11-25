package other;

import java.util.Stack;

//给定n个非负整数表示直方图的条高，其中每个条的宽度为1，求直方图中最大矩形的面积。
public class LargestRectangleinHistogram {

    public static void main(String[] args){
        int[] height = {3,6,4,5,3};
        System.out.println(largestRectangleArea(height));
    }

    //思路
    //当给定直方图高度为“升序”排列的时候，如[1,5,6,8]，我们只需要比较1*4, 5*3, 6*2,
    // 8*1的大小，找出最大值即可，一次遍历，O(n)即可完成；
    //如果出现降序 先对比降序点大的前面的值计算最大面积 然后把降序点前面比降序大的值降为降序点值
    //这样最后就形成了一条升序的栈
    public static int largestRectangleArea(int[] height){
        if (height == null || height.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int count = 0;//记录入栈的个数
        int maxArea = 0;
        for (int i=0;i<height.length;i++){
            if (stack.empty() || stack.peek() <= height[i]){
                stack.push(height[i]);
                count++;
            }else {
                int k=0;
                while (k < count && stack.peek() > height[i]){
                    maxArea = Math.max(maxArea,stack.pop()*(++k));
                }
                while (k-- >= 0){
                    stack.push(height[i]);
                }
                count++;
            }
        }
        for (int i=1;i<=count;i++){
            maxArea = Math.max(maxArea,stack.pop()*i);
        }
        return maxArea;
    }

    private static void out(Stack<Integer> stack){
        Stack<Integer> stack1 = (Stack<Integer>) stack.clone();
        while (!stack1.empty()){
            System.out.print(stack1.pop() +" ");
        }
        System.out.println();
    }

}
