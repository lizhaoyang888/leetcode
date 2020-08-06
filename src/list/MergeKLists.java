package list;

import util.ListNode;

import java.util.ArrayList;

/**
 * @Author: lichaoyang
 * @Date: 2020-04-13 19:11
 */

//合并k个已排序的链表并将其作为一个已排序的链表返回
public class MergeKLists {
    public static void main(String[] args) {
        ListNode one = new ListNode(0);
        ListNode p = one;
        for (int i=1;i<50;i=i+4){
            ListNode node = new ListNode(i);
            p.next = node;
            p = p.next;
        }
        ListNode two = new ListNode(0);
        p = two;
        for (int j=2;j<50;j=j+4){
            ListNode node = new ListNode(j);
            p.next = node;
            p = p.next;
        }
        ListNode three = new ListNode(0);
        p = three;
        for (int k=3;k<50;k=k+4){
            ListNode node = new ListNode(k);
            p.next = node;
            p = p.next;
        }
        ListNode four = new ListNode(0);
        p = four;
        for (int f=4;f<50;f=f+4){
            ListNode node = new ListNode(f);
            p.next = node;
            p = p.next;
        }
        out(one);out(two);out(three);out(four);

        ArrayList<ListNode> lists = new ArrayList<>();
        lists.add(one);lists.add(two);lists.add(three);lists.add(four);
        MergeKLists mergeKLists = new MergeKLists();
        out(mergeKLists.mergeKLists(lists));

    }

    public static void out(ListNode node){
        ListNode p = node;
        while (p != null){
            System.out.print(p.val+"->");
            p = p.next;
        }
        System.out.println();
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists){
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        NodeHeap nodeHeap = new NodeHeap();
        for (ListNode node:lists){
            if (node != null) {
                nodeHeap.add(node);
            }
        }
        nodeHeap.rush();
        while (!nodeHeap.isEmpty()){
            tail.next = nodeHeap.pop();
            tail = tail.next;
            if (tail.next != null){
                nodeHeap.add(tail.next);
                nodeHeap.rush();
            }
        }
        return dummy.next;
    }



    class NodeHeap{
        ListNode[] arr = new ListNode[10];
        int index = 0;
        public void add(ListNode node){
            arr[index++] = node;
        }

        public ListNode pop(){
            ListNode node = arr[0];
            arr[0] = arr[--index];
            return node;
        }

        public void rush(){
            heap(arr,index);
        }

        public boolean isEmpty(){
            return index<=0?true:false;
        }

        public void heap(ListNode[] arr,int size){
            for (int i=size-1;i>=0;i--){
                heap(arr,i,size);
            }
        }
        public void heap(ListNode[] arr,int current,int size){
            if (current < size){
                int left = current*2+1;
                int right = current*2+2;
                int min = current;
                if (left < size){
                    if(arr[left].val < arr[min].val){
                        min = left;
                    }
                }
                if (right < size){
                    if(arr[right].val < arr[min].val){
                        min = right;
                    }
                }
                if (min != current){
                    ListNode temp = arr[min];
                    arr[min] = arr[current];
                    arr[current] = temp;
                    heap(arr, min, size);
                }
            }
        }
    }

}
