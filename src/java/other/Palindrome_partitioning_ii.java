package java.other;

/**
 * 给定一个字符串s，分区s使得分区的每个子字符串都是回文。
 * 返回s的回文分区所需的最小割数。
 */
public class Palindrome_partitioning_ii {

    //s[i][j]是回文串 f[i][j]=0;
    //否则增加一个割点p s[i][j] = s[i][p]+s[p+1][j] f[i][j] = f[i][p]+f[p+1][j]+1
    public int minCut(String s) {
        int[][] f = new int[s.length()][s.length()];
        for (int t=0;t<s.length();t++){
            for (int i=0,j=t;j<s.length();i++,j++){
                f[i][j] = help(s,i,j,f);
            }
        }
        return f[0][s.length()-1];
    }
    public int help(String str,int i,int j,int[][] f){
        if (isHuiwen(str, i, j)){
            return 0;
        }
        int min = str.length();
        for (int p=i;p<j;p++){
            int a = f[i][p];
            int b = f[p+1][j];
            a = a+b+1;
            min = min < a?min:a;
        }
        return min;
    }
    public boolean isHuiwen(String str,int i,int j){
        while (i<j){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
