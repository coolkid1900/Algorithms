package offer;

/**
 * Created by su on 16/5/17.
 */
public class Power {
    public static void main(String[] args) {
        System.out.println(Solution(2,-2));

    }

    public static double Solution(double base, int exponent) {
        double result=1;
        if (exponent>0){
            for (int i=0;i<exponent;i++){
                result=result*base;
            }
            return result;
        }else if (exponent<0){
            for (int j=0;j<-1*exponent;j++){
                result=1/base*result;
            }
            return  result;
        }else {
            return 1;
        }
    }
}
