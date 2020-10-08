package java.list;

import java.util.Stack;

/**
 * @Author: lichaoyang
 * @Date: 2020-09-09 20:32
 */
public class StackQueue {

    Stack<Integer> stackA = new Stack<>();
    Stack<Integer> stackB = new Stack<>();


    public void enQueue(int val){
        stackA.push(val);
    }

    public int deQueue(){
        if (stackB.empty()){
            while (!stackA.empty()) {
                stackB.push(stackA.pop());
            }
        }
        return stackB.pop();
    }
}
