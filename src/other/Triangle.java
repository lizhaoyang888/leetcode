package other;

import java.util.ArrayList;

/**
 * 给定一个三角形，从上到下求最小路径和
 */
public class Triangle {

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        //最底一层
        ArrayList<Integer> last = triangle.get(triangle.size()-1);
        int[] dp = new int[last.size()];
        for (int i=0;i<last.size();i++){
            dp[i] = last.get(i);
        }
        //从倒数第二层开始往上遍历
        for (int i=triangle.size()-2;i>=0;i--){
            ArrayList<Integer> current = triangle.get(i);
            for (int j=0;j<current.size();j++){
                dp[j] = current.get(j)+Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }

}
