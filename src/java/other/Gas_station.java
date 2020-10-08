package java.other;

/**
 * 沿环形路线有N个加油站，其中加油站i的汽油量为gas[i]。
 */
public class Gas_station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 ||cost == null || cost.length == 0){
            return -1;
        }
        int start = gas.length-1;
        int end = 0;
        int sum = gas[start] - cost[start];
        while (start > end){
            if (sum >= 0){
                sum += gas[end]-cost[end];
                end++;
            }else {
                --start;
                sum += gas[start] - cost[start];
            }
        }
        return sum>=0?start:-1;
    }
}
