package list;

import java.util.Stack;

/**
 * @Author: lichaoyang
 * @Date: 2020-09-09 20:09
 */

/**
 * 使出栈、入栈、获取栈最小值的时间复杂度都为o(1)
 */
public class MinValStack {

    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int val){
        mainStack.push(val);
        if (mainStack.empty() || mainStack.peek() >= val){
            minStack.push(val);
        }
    }

    public int pop(){
        if (mainStack.peek() == mainStack.peek()){
            minStack.pop();
        }
        return mainStack.pop();
    }

    public int getMin(){
        if (mainStack.empty()){
            return 0;
        }
        return minStack.peek();
    }
}
