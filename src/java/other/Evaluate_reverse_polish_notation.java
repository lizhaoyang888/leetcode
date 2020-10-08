package java.other;

import java.util.Stack;

/**
 * 用反向波兰表示法计算算术表达式的值。
 */
public class Evaluate_reverse_polish_notation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0;i<tokens.length;i++){
            try{
                int num = Integer.parseInt(tokens[i]);
                stack.add(num);
            }catch (Exception e) {
                int b = stack.pop();
                int a = stack.pop();
                stack.add(get(a, b, tokens[i]));
            }
        }
        return stack.pop();
    }
    private int get(int a,int b,String token){
        switch (token){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "/":
                return a/b;
            case "*":
                return a*b;
            default:
                return 0;
        }
    }
}
