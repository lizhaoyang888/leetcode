package java.other;

/**
 * 给定一个包含' x '和' o '的2D板，捕获由' x '包围的所有区域。
 * 在被包围的区域中，通过将所有的o都翻转到x来捕获区域。
 */
public class Surrounded_regions {

    //先遍历四条外边 如果有点为O 就深度遍历 将它的邻接点为O的换为* 遍历完后就剩下的O换为X
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        int rowNum = board.length;
        int colNum = board[0].length;
        //第一行和最后一行
        for (int i=0;i<colNum;i++){
            dfs(board,0,i);
            dfs(board,rowNum-1,i);
        }
        //第一列和最后一列
        for (int j=0;j<rowNum;j++){
            dfs(board,j,0);
            dfs(board,j,colNum-1);
        }
        for (int i=0;i<rowNum;i++){
            for (int j=0;j<colNum;j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(char[][] board,int row,int col){
        int rowNum = board.length;
        int colNum = board[0].length;
        if (board[row][col] == 'O'){
            board[row][col] = '*';
            if (row < rowNum-1) {
                dfs(board, row + 1, col);
            }
            if (row > 0) {
                dfs(board, row - 1, col);
            }
            if (col < colNum-1) {
                dfs(board, row, col + 1);
            }
            if (col > 0) {
                dfs(board, row, col - 1);
            }
        }
    }
}
