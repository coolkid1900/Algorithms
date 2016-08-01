package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by su on 16/5/17.
 */
public class reOrderArray {
    public static void main(String[] args) {

    }

    public static void Solution(int [] array) {
        List<Integer> odds=new ArrayList<>();
        for (int i=0;i<array.length;i++){
            if (array[i]%2==1){
               odds.add(array[i]);
            }
        }

    }
}
