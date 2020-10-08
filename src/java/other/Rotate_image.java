package java.other;

//把这个二维图像按顺时针旋转90度
public class Rotate_image {

    //先沿着对角线旋转 再按水平方向旋转
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        //对角线旋转
        for (int i=0;i<row;i++){
            for (int j=0;j<row-i;j++){
                //swap(matrix[i][j],matrix[row-1-j][row-1-i]);
                swap(matrix,i,j,row-1-j,row-1-i);
            }
        }
        //水平旋转
        for (int i=0;i<row/2;i++){
            for (int j=0;j<row;j++){
                //swap(matrix[i][j],matrix[row-1-i][j]);
                swap(matrix,i,j,row-1-i,j);
            }
        }
    }

    private void swap(int[][] A,int i,int j,int m,int n){
        int temp = A[i][j];
        A[i][j] = A[m][n];
        A[m][n] = temp;
    }

}
