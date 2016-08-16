package offer;

/**
 * Created by su on 16/8/15.
 */
public class ReverseSentence {
    public String Solution(String str) {
        String result="";
        if (str.equals(" ")){
            return " ";
        }
        String[] array=str.split(" ");
        for (int i=0,j=array.length-1;i<array.length&&j>=0;i++,j--){
            if (j<=i){
                break;
            }
            String temp=array[i];
            array[i]=array[j];
            array[j]=temp;
        }
        for (int i=0;i<array.length-1;i++){
            result+=array[i]+" ";
        }
        result=result+array[array.length-1];
        return result;
    }

    public static void main(String[] args) {
        ReverseSentence reverseSentence=new ReverseSentence();
        reverseSentence.Solution(" ");
    }
}
