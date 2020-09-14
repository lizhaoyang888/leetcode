package tree;

import java.util.Arrays;

/**
 * @Author: lichaoyang
 * @Date: 2020-09-07 20:44
 */

/**
 * 优先队列
 */
public class PriorityQueue {

    private int size = 0;
    private int[] array;

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        for (int i=0;i<5;i++){
            queue.enQueue(i+1);
        }
        for (int i=9;i>5;i--){
            queue.enQueue(i+1);
        }
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        queue.enQueue(2);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }


    public PriorityQueue(){
        array = new int[32];
    }

    public void enQueue(int key){
        if (size >= array.length){
            resize();
        }
        array[size++] = key;
        upAjust(array);
    }

    public int deQueue(){
        if (size == 0){
            return 0;
        }
        int val = array[0];
        array[0] = array[--size];
        downAjust(array);
        return val;
    }

    public void resize(){
        int newSize = size * 2;
        this.array = Arrays.copyOf(this.array,newSize);
    }


    /**
     * 将顶点下沉
     * @param array
     */
    public void downAjust(int[] array){
        int parentIndex = 0;
        int length = size;
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex] > array[childIndex + 1]) {
                childIndex++;
            }
            if (temp < array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 将结尾上浮
     * @param array
     */
    public void upAjust(int[] array){
        int childIndex = size-1;
        int temp = array[childIndex];
        int parentIndex = (childIndex-1)/2;
        while (childIndex > 0) {
            if (temp > array[parentIndex]) {
                break;
            }
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }
        array[childIndex] = temp;
    }


}
