package offer;

import java.util.Arrays;

/**
 * Created by su on 16/8/11.
 */
public class MoreThanHalfNum {

    public int Solution(int [] array) {
        int result=0;
        int order=0;
        if (array==null||array.length==0){
            return result;
        }
        if (array.length<=1){
            return array[0];
        }

        Arrays.sort(array);

        if (array.length%2==0){
            order=array.length/2;
        }else {
            order=array.length/2+1;
        }
        if (array[order]==array[order-1]){
            result=array[array.length/2];
        }else {
            result=0;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] array={1,2,3,2,2,2,5,4,2};
        int[] array={1,2,3,2,4,2,5,2,3};
        MoreThanHalfNum moreThanHalfNum=new MoreThanHalfNum();
        moreThanHalfNum.Solution(array);
    }
}
