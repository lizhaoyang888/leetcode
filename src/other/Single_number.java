package other;

public class Single_number {

    public int singleNumber(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        int res = 0;
        for (int i=0;i<A.length;i++){
            res ^= A[i];
        }
        return res;
    }

}
