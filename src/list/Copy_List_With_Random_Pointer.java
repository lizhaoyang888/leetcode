package list;

import util.RandomListNode;

public class Copy_List_With_Random_Pointer {


    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return head;
        }
        RandomListNode p = head;
        //第一遍遍历 在原节点后插入新节点
        while (p != null){
            RandomListNode copy = new RandomListNode(p.value);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }
        //第二遍遍历 设置新节点的random
        //为新节点的random指针赋值，若原节点random为NULL 不用管新节点(默认是NULL)
        //若原节点random不为NULL，将新节点的random赋值为原节点random后面的那一个(因为后面这个是复制出来的)
        p = head;
        while (p != null){
            if (p.random != null) {
                p.next.random = p.random.next;//原节点的random的后继新节点
            }
            p = p.next.next;
        }
        //分离原节点和新节点
        RandomListNode newhead = head.next;
        p = head;
        while (p != null){
            RandomListNode newnode = p.next;
            p.next = newnode.next;
            if (p.next != null){
                newnode.next = p.next.next;
            }
            p = p.next;
        }
        return newhead;
    }

}
