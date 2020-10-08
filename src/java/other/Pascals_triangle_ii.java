package java.other;

import java.util.ArrayList;

/**
 * 给定一个指标k，返回杨辉三角形的第k行。
 */
public class Pascals_triangle_ii {

    public ArrayList<Integer> getRow(int rowIndex) {
        if (rowIndex < 0){
            return null;
        }
        ArrayList<Integer> dp = new ArrayList<Integer>(rowIndex+1);
        dp.add(1);
        for (int i=1;i<=rowIndex;i++){
            for (int j=dp.size()-2;j>=0;j--){
                dp.set(j+1,dp.get(j)+dp.get(j+1));
            }
            dp.add(1);
        }
        return dp;
    }

}
