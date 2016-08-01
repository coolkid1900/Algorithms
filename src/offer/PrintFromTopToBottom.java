package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Created by su on 16/6/1.
 */
public class PrintFromTopToBottom {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        while (root!=null||!queue.isEmpty()){
            if (root!=null){
                list.add(root.val);
                queue.add(root.left);
                queue.add(root.right);
                root=queue.poll();
            }else {
                root=queue.poll();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        ArrayList<Integer> list=PrintFromTopToBottom(root);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

}
