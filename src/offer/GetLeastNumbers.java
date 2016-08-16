package offer;

import java.util.*;

/**
 * Created by su on 16/8/11.
 */
public class GetLeastNumbers {
    public ArrayList<Integer> Solution(int [] input, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        Arrays.sort(input);
        if (input.length<k||input==null){
            return list;
        }else {
            for (int i=0;i<k;i++){
                list.add(input[i]);
            }
            return list;
        }
    }
}
