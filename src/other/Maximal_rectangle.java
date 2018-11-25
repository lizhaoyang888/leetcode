package other;

import java.util.Stack;

public class Maximal_rectangle {

    public static void main(String[] args){
        char[][] dp = {{'0','1','1','0','1'},
                {'1','1','0','1','0'},{'0','1','1','1','0'},
                {'1','1','1','1','0'},{'1','1','1','1','1'},
                {'0','0','0','0','0'}};
        Maximal_rectangle m = new Maximal_rectangle();
        System.out.println(m.maximalRectangle(dp));
    }


    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int max = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] height = new int[col];
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (matrix[i][j] == '1'){
                    height[j]++;
                }else {
                    height[j] = 0;
                }
            }
            max = Math.max(max,largestRectangleArea(height));
        }
        return max;

    }

    private int largestRectangleArea(int[] height){
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

    private void out(int[] dp){
        for (int i=0;i<dp.length;i++){
            System.out.print(dp[i]+" ");
        }
        System.out.println();
    }

}
