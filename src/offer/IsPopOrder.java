package offer;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by su on 16/6/1.
 */
public class IsPopOrder {

     public static boolean Solution(int [] pushA,int [] popA){
         if (pushA.length == 0 || popA.length == 0) {
             return false;
         }
         Stack<Integer> stack = new Stack<Integer>();
         int j = 0;
         for (int i = 0; i < popA.length; i++) {
             stack.push(pushA[i]);
             while (j < popA.length && stack.peek() == popA[j]) {
                 stack.pop();
                 j++;
             }

         }
         return stack.empty() ? true : false;
     }

    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,4,5};
        int[] b=new int[]{4,5,3,2,1};
        System.out.println(Solution(a,b));
    }
}
