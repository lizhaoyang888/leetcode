package java.other;

//假设一个排好序的数组在某个未知的主轴上旋转。
//(即。，0 1 2 4 5 6 7可能变成4 5 6 7 0 1 2)。
public class Search_in_rotated_sorted_array {

    public int search(int[] A, int target) {
        int end = A.length-1,begin = 0;
        //如果首位数字小于末尾数字 说明数组没有旋转
        //如果大于 说明旋转了
        //首先找到旋转点 把数组分成排好序的两部分 在排好序的两部分里再使用二分查找
        if (A[0] < A[end]){
            return binarysearch(A,target,begin,end);
        }else {
            int mid = 0;
            while (A[begin] > A[end]){
                if (end - begin == 1){
                    break;
                }
                mid = (end+begin)>>1;
                if (A[mid] > A[begin]){
                    begin = mid;
                }else {
                    end = mid;
                }
            }
            if (target >= A[0]){
                return binarysearch(A,target,0,begin);
            }else {
                return binarysearch(A,target,begin+1,A.length-1);
            }
        }
    }
    //二分查找
    private int binarysearch(int[] num,int target,int begin,int end){
        int mid = 0;
        while (begin <= end){
            mid = (end+begin)>>1;
            if (num[mid] > target){
                end = mid-1;
            }else if (num[mid] < target){
                begin = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

}
