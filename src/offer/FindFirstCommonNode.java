package offer;

/**
 * Created by su on 16/8/10.
 */
public class FindFirstCommonNode {
    public ListNode Solution(ListNode pHead1, ListNode pHead2) {
        int length1=0;
        int length2=0;
        if (pHead1==null||pHead2==null)
            return null;
        ListNode result=null;
        for (ListNode temp1=pHead1;temp1!=null;temp1=temp1.next){
            length1++;
        }
        for (ListNode temp2=pHead2;temp2!=null;temp2=temp2.next){
            length2++;
        }
        if (length1>=length2){
            for (int i=0;i<length1-length2;i++){
                pHead1=pHead1.next;
            }
        }else {
            for (int i=0;i<length2-length1;i++){
                pHead2=pHead2.next;
            }
        }
        for (ListNode temp1=pHead1,temp2=pHead2;temp1!=null&&temp2!=null;temp1=temp1.next,temp2=temp2.next){
            if (temp1.val==temp2.val){
                result=temp1;
                break;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        listNode1.next=new ListNode(4);
        listNode1.next.next=new ListNode(3);
//        ListNode listNode1=null;

        ListNode listNode2=new ListNode(2);
        listNode2.next=new ListNode(5);
        listNode2.next.next=new ListNode(4);
        listNode2.next.next.next=new ListNode(3);

        FindFirstCommonNode findFirstCommonNode=new FindFirstCommonNode();
        findFirstCommonNode.Solution(listNode1,listNode2);
    }
}
