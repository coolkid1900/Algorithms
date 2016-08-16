package offer;

/**
 * Created by su on 16/8/10.
 */
public class GetNumberOfK {
    public int Solution(int [] array , int k) {
        int i;
        int j;
        for (i=0;i<array.length;i++){
            if (array[i]==k)
                break;
        }
        for (j=array.length-1;j>=0;j--){
            if (array[j]==k)
                break;
        }
        if (j==-1){
            return 0;
        }else {
            return j-i+1;
        }
    }

    public static void main(String[] args) {
//        int[] array={1,2,3,3,3,3,4,5};
        int[] array={1,3,3,3,3,4,5};
        GetNumberOfK getNumberOfK=new GetNumberOfK();
        getNumberOfK.Solution(array,2);
    }
}
