package java.other;

//有N个孩子站成一排。每个孩子都被赋予一个评价值。
//您正在按照以下要求向这些儿童发放糖果:
//每个孩子必须至少有一颗糖果。
//得分较高的孩子比他们的邻居得到更多的糖果。
//你最少要给多少糖果?

public class Candy {

    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        //初始化每个小孩分一个糖果
        for (int i=0;i<candy.length;i++){
            candy[i] = 1;
        }
        //从左往右 若当前点比前一个点高就比前者多一块
        for (int j=1;j<candy.length;j++){
            if (ratings[j] > ratings[j-1]){
                candy[j] = candy[j-1]+1;
            }
        }
        //从右往左 若当前点比后一个点高就比后者多一块
        for (int j=candy.length-2;j>=0;j--){
            if (ratings[j] > ratings[j+1]){
                if (candy[j] <= candy[j+1]) {
                    candy[j] = candy[j + 1] + 1;
                }
            }
        }
        int sum = 0;
        for (int j=0;j<candy.length;j++){
            sum += candy[j];
        }
        return sum;
    }

}
