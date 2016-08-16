package nowcoder;

/**
 * Created by su on 16/8/1.
 */
import java.util.*;


public class Cmp {
    List<Integer> maxlist=new ArrayList<>();
    List<Integer> minlist=new ArrayList<>();
    int max;
    int min;
    int[] array;
    public int cmp(int g1, int g2, int[][] records, int n) {
        // write code here
        for (int i=0;i<n;i++){
            array=records[i];
           if (i==0){
               max=array[0];
               min=array[1];
               maxlist.add(max);
               minlist.add(min);
           }else {
               if (max==array[1]){
                   int temp=max;
                   max=array[0];
                   maxlist.remove(maxlist.size()-1);
                   maxlist.add(max);
                   maxlist.add(temp);
               }
               if (min==array[0]){
                   min=array[1];
                   minlist.add(min);
               }
           }
        }
        maxlist.addAll(maxlist.size(),minlist);
        if (maxlist.indexOf(g1)<maxlist.indexOf(g2))
            return 1;
        else if (maxlist.indexOf(g1)>maxlist.indexOf(g2))
            return -1;
        else
            return 0;
    }

    public static void main(String[] args) {
        Cmp cmp=new Cmp();
        int[][] records={{1,2},{2,4},{1,3},{4,3},{5,1}};
        cmp.cmp(2,3,records,5);
    }

}
