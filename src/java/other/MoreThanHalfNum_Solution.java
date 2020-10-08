package other;

/**
 * @Author: lichaoyang
 * @Date: 2020-09-24 14:51
 */
public class MoreThanHalfNum_Solution {

    public int moreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int temp = array[0];
        int times = 0;
        for (int i = 1; i < array.length; i++) {
            if (temp == array[i]) {
                times++;
            } else if (times == 0) {
                temp = array[i];
                times++;
            } else {
                times--;
            }
        }
        times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == temp) {
                times++;
            }
        }
        if (times * 2 > array.length) {
            return temp;
        }
        return 0;
    }
}
