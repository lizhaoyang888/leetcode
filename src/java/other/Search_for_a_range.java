package java.other;

public class Search_for_a_range {

    public static int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (A == null || target < 0){
            return res;
        }
        int low = 0,high = A.length-1;
        while (low <= high){
            int mid = (low + high)>>1;
            if (A[mid] < target){//向左夹逼 找到左边界
                low = mid+1;
            }else {
                high = mid-1;
            }
            System.out.println("low:"+low+" high:"+high+" mid:"+mid);
        }
        int low2 = 0,high2 = A.length-1;
        while (low2 <= high2){
            int mid2 = (low2 + high2)>>1;
            if (A[mid2] <= target){//向右夹逼 找到右边界
                low2 = mid2+1;
            }else {
                high2 = mid2-1;
            }
            System.out.println("low2:"+low2+" high2:"+high2+" mid2:"+mid2);
        }
        if (low <= high2){
            res[0] = low;
            res[1] = high2;
        }
        return res;
    }


    public static void main(String[] args){
        int[] A = {2,2,2,2,3,4,5,6};
        int[] res;
        res = searchRange(A,2);
        System.out.println(res[0]+" "+res[1]);
    }

}
