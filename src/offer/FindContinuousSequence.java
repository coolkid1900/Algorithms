package offer;

import java.util.ArrayList;

/**
 * Created by su on 16/8/13.
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> Solution(int sum) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if (sum<3)
            return result;
        int s= (int) Math.sqrt(2*sum);
        for (int i=s;i>=2;i--){
            if (2*sum%i==0){
                int j=2*sum/i;
                if (i%2==0&&j%2!=0||i%2!=0&&j%2==0){
                    int a1=(j-i+1)/2;
                    int an=(j+i-1)/2;
                    ArrayList<Integer> temp=new ArrayList<>();
                    for (int n=a1;n<=an;n++){
                        temp.add(n);
                    }
                    result.add(temp);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindContinuousSequence findContinuousSequence=new FindContinuousSequence();
        findContinuousSequence.Solution(3);
    }
}
