package java.other;

import java.util.ArrayList;

public class Gray_code {

    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i=0;i<n;i++){
            int high_bit = 1<<i;
            //在已有的数前面加1或0来扩充位数 加0就是它本身 加1就是在最高位使用或运算
            for (int j=list.size()-1;j>=0;j--){
                list.add(high_bit | list.get(j));
            }
        }
        return list;
    }

}
