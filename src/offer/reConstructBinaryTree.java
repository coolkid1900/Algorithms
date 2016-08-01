package offer;

/**
 * Created by su on 16/5/5.
 */
public class reConstructBinaryTree {


    public TreeNode solution(int [] pre,int [] in) {
        TreeNode treeNode=solution(pre,0,pre.length-1,in,0,in.length-1);
        return treeNode;
    }

    private TreeNode solution(int[] pre,int prestart,int preend,int[] in,int instart,int inend){
        if (prestart>preend||instart>inend){
            return null;
        }
        TreeNode treeNode=new TreeNode(pre[prestart]);
        for (int i=instart;i<=inend;i++){
            if (in[i]==pre[prestart]){
                treeNode.left=solution(pre,prestart+1,prestart+i-instart,in,instart,i-1);
                treeNode.right=solution(pre,i-instart+prestart+1,preend,in,i+1,inend);
            }
        }
        return treeNode;
    }

    public static void main(String[] args) {

    }
}
