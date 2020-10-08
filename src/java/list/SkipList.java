package java.list;

/**
 * @Author: lichaoyang
 * @Date: 2019-12-17 21:19
 */

import java.util.Random;

/**
 * 跳跃表  插入、删除、查找时间复杂度均为O(logn)  空间复杂度为O(n)
 */
public class SkipList {

    private int level = 5;

    SkipListNode head = new SkipListNode(Integer.MIN_VALUE);

    /**
     * 初始化
     */
    public SkipList(){
        SkipListNode cur = head;
        for (int i=0;i<level;i++){
            SkipListNode down = new SkipListNode(Integer.MIN_VALUE);
            SkipListNode next = new SkipListNode(Integer.MAX_VALUE);
            cur.next = next;
            cur.down = down;
            cur = cur.down;
        }
        cur = null;
    }

    /**
     * 插入一个节点
     * @param val
     */
    public void insert(int val){
        SkipListNode cur = head;
        int tempLevel = level;
        int k = randomLevel();
        while (tempLevel-- != k){
            cur = cur.down;
        }
        SkipListNode tempNode = null;
        tempNode = cur;
        while (k-- != 0){
            while (val > tempNode.next.val){
                tempNode = tempNode.next;
            }
            SkipListNode node = new SkipListNode(val);
            node.next = tempNode.next;
            tempNode.next = node;
            tempNode = tempNode.down;
        }

    }

    public void out() {
        SkipListNode temp = head;
        SkipListNode cur = null;
        while (level-- != 0) {
            cur = temp;
            System.out.print(level+"层：");
            while (cur.next.val < Integer.MAX_VALUE) {
                System.out.print(cur.next.val + "->");
                cur = cur.next;
            }
            System.out.println();
            temp = temp.down;
        }
    }

    public int randomLevel(){
        int k = 1;
        while (new Random().nextInt()%2 == 0){
            k++;
        }
        return k>level?level:k;
    }


    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insert(1);
        skipList.insert(3);
        skipList.insert(7);
        skipList.insert(4);
        skipList.out();
    }






    class SkipListNode{
        int val;
        SkipListNode next = null;
        SkipListNode down = null;

        SkipListNode(int val){
            this.val = val;
        }
    }

}
