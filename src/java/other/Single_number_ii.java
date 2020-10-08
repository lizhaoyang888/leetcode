package java.other;

/**
 * 给定一个整数数组，除一个元素外，每个元素出现三次。找到那一个。
 */
public class Single_number_ii {

    public static void main(String[] args){
        int[] A = {7,8,9,7,8,7,8};
        System.out.println(singleNumber2(A));
    }
    public static String go(int value){
        String res="";
        int index=32;
        while (index > 0){
            res = ((value&1) == 1?1:0) + res;
            value = value>>1;
            index--;
            if (index%4==0){
                res = " "+res;
            }
        }
        return res;
    }
    //由于只有一个出现一次的数字，其余都是出现三次，那么有如下思路
    // 针对于序列中出现三次的所有数字的每一位来说，相加的结果只有两种
    //1+1+1==3 或者0+0+0=0
    //那么再加上只出现一次的数字的对应位数字的话，也有两种0或者4
    //所以我们可以对上述的每一位求和之后对3取余，结果将会是1或者0
    //也就是代表了出现一次的的这个数字对应位置上是1或者0
    public static int singleNumber(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        int len = A.length;
        int sum=0,res=0;
        for (int i=0;i<32;i++){
            sum = 0;
            for (int j=0;j<len;j++){
                sum += A[j]>>i & 1;
            }
            res |= sum%3<<i;
        }
        return res;
    }

    public static int singleNumber2(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        int ones=0,twos=0,threes=0;
        for (int i=0;i<A.length;i++){
            int t = A[i];
            twos |= ones & t;
            System.out.println("twos:"+go(twos));
            ones ^= t;
            System.out.println("ones:"+go(ones));
            threes = twos & ones;
            System.out.println("threes:"+go(threes));
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
}
