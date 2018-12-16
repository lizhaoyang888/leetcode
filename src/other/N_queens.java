package other;

import java.util.ArrayList;

//八皇后问题  一行 一列 对角线都不能出现重复的皇后
public class N_queens {

    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<>();
        char[][] temp = new char[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                temp[i][j] = '.';
            }
        }
        dfs(res,temp,n,0);
        return res;
    }

    private void dfs(ArrayList<String[]> res,char[][] temp,int n,int row){
        if (row == n){
            String[] strings = new String[n];
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<n;i++){
                String str = new String(temp[i]);
                strings[i] = str;
            }
            res.add(strings);
        }
        for (int j=0;j<n;j++){
            if (isValid(temp,n,row,j)){
                temp[row][j] = 'Q';
                dfs(res, temp, n, row+1);
                temp[row][j] = '.';
            }
        }
    }

    private boolean isValid(char[][] temp,int n,int row,int col){
        //验证列
        for (int i=0;i<row;i++){
            if (temp[i][col] == 'Q') {
                return false;
            }
        }
        //验证对角线
        for (int i = row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if (temp[i][j] == 'Q'){
                return false;
            }
        }
        for (int i=row-1,j=col+1;i>=0 && j<n;i--,j++){
            if (temp[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

}
