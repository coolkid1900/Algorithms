package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by su on 16/5/5.
 */
public class PrintListFromTailToHead {
    public ArrayList<Integer> solution(ListNode listNode) {
        Stack<Integer> stack=new Stack<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        ArrayList<Integer> list=new ArrayList<>();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

}
