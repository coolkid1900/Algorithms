package offer;

/**
 * Created by su on 16/8/13.
 */
public class Is2n {
    public boolean Solution(int n){
        if (n<2)
            return false;
        while (n>=2){
            if (n%2!=0){
                return false;
            }else {
                n=n/2;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Is2n is2n=new Is2n();
        System.out.println(is2n.Solution(5));
    }
}
