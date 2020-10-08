package java.other;

//给定一块2D板和一个单词，查找该单词是否存在于网格中。
//单词可以由顺序相邻单元格的字母构成，其中“相邻”单元格是指水平或垂直相邻的单元格。同一字母单元格只能使用一次。
public class Word_search {

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (dfs(board,word,visited,i,j,row-1,col-1,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board,String word,boolean[][] visited,int i,int j,int row,int col,int count){
        if (count == word.length()){
            return true;
        }
        if (i<0 || i>row || j<0 || j>col || visited[i][j] || board[i][j] != word.charAt(count)){
            return false;
        }
        visited[i][j] = true;
        boolean ret = dfs(board, word, visited, i+1, j, row, col, count+1) ||
                dfs(board, word, visited, i-1, j, row, col, count+1) ||
                dfs(board, word, visited, i, j+1, row, col, count+1) ||
                dfs(board, word, visited, i, j-1, row, col, count+1);
        visited[i][j] = false;
        return ret;
    }
}
