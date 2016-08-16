package offer;

/**
 * Created by su on 16/8/15.
 */
public class LeftRotateString {
    public String Solution(String str,int n) {
        String result="";
        if (n<=str.length()){
            String temp=str+str.substring(0,n);
            result=temp.substring(n,temp.length());
            return result;
        }else {
            return str;
        }
    }
}
