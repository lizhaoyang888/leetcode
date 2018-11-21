package other;

public class Distinct_subsequences {


    public static void main(String[] args){
        String S = "rabbbit";
        String T = "rabbit";
        System.out.println(numDistinct(S,T));
    }
    public static int numDistinct(String S, String T) {
        if (S==null || S.length()==0 || T==null){
            return 0;
        }
        int row = S.length()+1;
        int col = T.length()+1;
        int[][] dp = new int[row][col];
        for (int i=0;i<col;i++){
            dp[0][i] = 0;
        }
        for (int j=0;j<row;j++){
            dp[j][0] = 1;
        }
        for (int j=1;j<col;j++){
            for (int i=1;i<row;i++){
                if (S.charAt(i-1) == T.charAt(j-1)){
                    //S[i] == T[j] 说明新加的母串字母带来了新的可能性，我们不仅算上dp(i)(j-1)，也要算上新的可能性
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                }else {
                    //S[i] != T[j] 说明新加的母串字母没有产生新的可能性，可以沿用该子串在较短母串的出现次数
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[row-1][col-1];
    }


}
