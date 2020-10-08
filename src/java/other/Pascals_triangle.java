package java.other;

import java.util.ArrayList;

public class Pascals_triangle {

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<numRows;i++){
            for (int j=list.size()-2;j>=0;j--){
                list.set(j+1,list.get(j)+list.get(j+1));
            }
            list.add(1);
            ArrayList<Integer> temp = (ArrayList<Integer>)list.clone();
            result.add(temp);
        }
        return result;
    }

}
