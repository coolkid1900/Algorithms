package offer;

import java.util.Arrays;

/**
 * Created by su on 16/8/15.
 */
public class IsContinuous {
    public boolean isContinuous(int [] numbers) {
        boolean result=false;
        Arrays.sort(numbers);
        for (int i=1;i<numbers.length;i++){
            if (numbers[i]==numbers[i-1]){
                result=false;
            }
        }
        if (numbers[0]==0&&numbers[1]!=0&&numbers[numbers.length-1]-numbers[1]<4){
            result=true;
        }else if (numbers[0]==0&&numbers[1]==0&&numbers[numbers.length-1]-numbers[2]<3){
            result=true;
        }else if (numbers[0]!=0&&numbers[1]!=0&&numbers[numbers.length-1]-numbers[2]==4){
            result=true;
        }else {
            result=false;
        }
        return result;
    }
}
