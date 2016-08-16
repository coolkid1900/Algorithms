package offer;

/**
 * Created by su on 16/7/31.
 */
public class Merge {
    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     * @param list1 单调递增的链表1
     * @param list2 单调递增的链表2
     * @return 合成后的链表
     * 本题关键在于找到循环的条件while (list1!=null&&list2!=null),当list1或者list2有一个为null后,只需把剩余的另一个ListNode实例添加到合成链表后即可。
     */
    public ListNode Solution(ListNode list1,ListNode list2) {
        ListNode listNode=new ListNode(0);
        listNode.next=null;
        ListNode root=listNode;
        while (list1!=null&&list2!=null){
            if(list1.val<list2.val){
                //此处顺序一定不能写错,否则会造成listNode在首部一直循环,使listNode.next指向其本身
                listNode.next=list1;
                listNode=list1;
                list1=list1.next;
            }else {
                listNode.next=list2;
                listNode=list2;
                list2=list2.next;
            }
        }
        if (list1!=null){
            listNode.next=list1;
        }
        if (list2!=null){
            listNode.next=list2;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode list1=new ListNode(1);
        list1.next=new ListNode(3);
        ListNode list2=new ListNode(2);
        list2.next=new ListNode(4);
        Merge merge=new Merge();
        merge.Solution(list1,list2);
    }
}
