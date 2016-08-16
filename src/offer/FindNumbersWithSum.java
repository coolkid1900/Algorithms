package offer;

import java.util.ArrayList;

/**
 * Created by su on 16/8/13.
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> Solution(int [] array, int sum) {
        ArrayList<Integer> result=new ArrayList<>();
        for (int i=0;i<array.length/2+1;i++){
            for (int j=1;j<array.length;j++){
                if (sum==array[i]+array[j]){
                    result.add(array[i]);
                    result.add(array[j]);
                    return result;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        FindNumbersWithSum findNumbersWithSum=new FindNumbersWithSum();
        findNumbersWithSum.Solution(array,21);
    }
}
