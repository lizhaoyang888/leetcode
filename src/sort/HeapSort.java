package sort;

/**
 * @Author: lichaoyang
 * @Date: 2020-04-13 17:04
 */
public class HeapSort {


    public static void main(String[] args){
        int[] arr = new int[]{5,2,3,1,8,6,7,4};
//        for (int i=arr.length-1;i>=arr.length-2;i--){
//            maxHeapify(arr,i+1);
//            //把堆顶的数与堆尾的数交换
//            int temp = arr[i];
//            arr[i] = arr[0];
//            arr[0] = temp;
//        }
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
//        for (int j=1;j<=2;j++){
//            for (int i=0;i<arr.length-j;i++){
//                if (arr[i] >= arr[i+1]){
//                    int temp = arr[i];
//                    arr[i] = arr[i+1];
//                    arr[i+1] = temp;
//                }
//            }
//        }
        int max = 0, min = 0;
        if (arr[0] > arr[1]){
            max = arr[0];
            min = arr[1];
        }else {
            max = arr[1];
            min = arr[0];
        }
        for (int i=2;i<arr.length;i++){
            if (arr[i] > max){
                min = max;
                max = arr[i];
            }else if (arr[i] > min){
                min = arr[i];
            }
        }
        System.out.println(max);
        System.out.println(min);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void maxHeapify(int[] arr,int size){
        //一个普通的数组并不能有这种条件(父>子)，因此，我们往往是从数组最后一个元素来进行建堆
        for (int i = size-1;i>=0;i--){
            heapify(arr,i,size);
        }
    }

    public static void heapify(int[] arr,int currentRoot,int size){
        if (currentRoot < size){
            //完全二叉树有个特性：左边子节点位置 = 当前父节点的两倍 + 1，右边子节点位置 = 当前父节点的两倍 + 2
            int left = 2*currentRoot+1;
            int right = 2*currentRoot+2;
            //把当前节点位置看成是最大的
            int max = currentRoot;
            if (left < size) {
                if (arr[max] < arr[left]) {
                    max = left;
                }
            }
            if (right < size) {
                if (arr[max] < arr[right]) {
                    max = right;
                }
            }
            //如果最大的不是根元素位置，那么就交换
            if (max != currentRoot){
                int temp = arr[max];
                arr[max] = arr[currentRoot];
                arr[currentRoot] = temp;
                //继续比较，直到完成一次建堆
                heapify(arr, max, size);
            }
        }
    }

    static void out(int[] arr){
        int size = arr.length;
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}



