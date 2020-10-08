package java.other;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定二维平面上的n个点，求出同一直线上的最大点数。
 */
public class Max_points_on_a_line {

    public int maxPoints(Point[] points) {
        int len = points.length;
        if (len < 2){
            return len;
        }
        int ret = 0;
        for (int i=0;i<len;i++){
            int dup = 1;//重合的
            int vlt = 0;//垂直的
            Point a = points[i];
            Map<Float,Integer> map = new HashMap<>();
            for (int j=0;j<len;j++){
                if (i == j){
                    continue;
                }
                Point b = points[j];
                if (a.x == b.x){
                    if (a.y == b.y){
                        dup++;
                    }else {
                        vlt++; //水平的放在斜率为0的里面
                    }
                }else {
                    float k = (float) (a.y - b.y)/(a.x - b.x);
                    if (map.get(k) == null){
                        map.put(k,1);
                    }else {
                        map.put(k,map.get(k)+1);
                    }
                }
            }
            int max = vlt;
            for (float k:map.keySet()){
                max = Math.max(max, map.get(k));
            }
            ret = Math.max(ret, max + dup);
        }
        return ret;
    }



    class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
    }
}
