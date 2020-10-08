package java.other;

public class Minimum_window_substring {

    //1) begin开始指向0， end一直后移，直到begin - end区间包含T中所有字符。
    //记录窗口长度d
    //2) 然后begin开始后移移除元素，直到移除的字符是T中的字符则停止，此时T中有一个字符没被
    //包含在窗口，
    //3) 继续后移end，直到T中的所有字符被包含在窗口，重新记录最小的窗口d。
    //4) 如此循环知道end到S中的最后一个字符。
    public String minWindow(String S, String T) {
        int[] map = new int[128];
        //记录T中每个字符出现的次数
        for (int i=0;i<T.length();i++){
            map[T.charAt(i)]++;
        }
        //d记录最短窗口长度  counter记录剩余窗口长度
        int begin=0,end=0,d=Integer.MAX_VALUE,counter=T.length(),head=0;
        //end后移
        while (end < S.length()){
            //map大于0说明在T中出现过 ‘--’表示已经遍历过的没有在T中出现的字符为-1  为后面做铺垫
            if (map[S.charAt(end++)]-- > 0){
                counter--;
            }
            while (counter == 0){
                if (end-begin<d){
                    d = end - (head=begin);
                }
                //begin开始向后移 在T中出现过的为0  没有出现的为-1
                if (map[S.charAt(begin++)]++ == 0){
                    counter++;
                }
            }
        }
        return d==Integer.MAX_VALUE ? "" : S.substring(head,head+d);
    }

}
