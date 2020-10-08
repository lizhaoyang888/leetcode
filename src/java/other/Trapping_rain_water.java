package java.other;

public class Trapping_rain_water {

    public int trap(int[] A) {
        int maxIndex = 0;//最大值下标
        for (int i=0;i<A.length;i++){
            if (A[maxIndex] < A[i]){
                maxIndex = i;
            }
        }
        int left =0,right = 0;
        int sum = 0;
        //求左边容量
        for (int i=0;i<maxIndex;i++){
            if (A[i] > left){
                left = A[i];
            }else {
                sum += (left-A[i]);
            }
        }
        //求右边容量
        for (int i = A.length-1;i>maxIndex;i--){
            if (A[i] > right){
                right = A[i];
            }else {
                sum += (right-A[i]);
            }
        }
        return sum;
    }

}
