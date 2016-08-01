package AlgorithmTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by su on 16/5/26.
 */
public class Tree {
    private BinaryTreeNode root;

    // 递归中序遍历
    public void inOrder(BinaryTreeNode current) {
        if (current != null) {
            inOrder(current.llink);
            System.out.print(current.info);
            inOrder(current.rlink);
        }
    }

    // 非递归中序遍历
    public void nonRecursiveInOrder() {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode current;
        current = root;
        while ((current != null) || (!stack.empty())) {
            if (current != null) {
                stack.push(current);
                current = current.llink;
            } else {
                //左子节点没有数据,则取栈顶元素为current节点
                current = stack.peek();
                stack.pop();
                System.out.print(current.info);
                current = current.rlink;
            }
        }
    }

    // 递归前序遍历
    public void preOrder(BinaryTreeNode current) {
        if (current != null) {
            System.out.print(current.info);
            preOrder(current.llink);
            preOrder(current.rlink);
        }
    }

    /**
     * 非递归前序遍历,根据前序遍历访问的顺序，优先访问根结点，然后再分别访问左孩子和右孩子。即对于任一结点，其可看做是根结点，
     * 因此可以直接访问，访问完之后，若其左孩子不为空，按相同规则访问它的左子树；当访问其左子树时，再访问它的右子树。因此其处理过程如下：
     * 对于任一结点P：
     * 1)访问结点P，并将结点P入栈;
     * 2)判断结点P的左孩子是否为空，若为空，则取栈顶结点并进行出栈操作，并将栈顶结点的右孩子置为当前的结点P，循环至1);若不为空，则将P的左孩子置为当前的结点P;
     * 3)直到P为NULL并且栈为空，则遍历结束。
     */
    public void nonRecursivePreOrder() {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode current;
        current = root;
        while ((current != null) || (!stack.isEmpty())) {
            if (current != null) {
                System.out.print(current.info);
                stack.push(current);
                current = current.llink;
            } else {
                current =  stack.peek();
                stack.pop();
                current = current.rlink;
            }
        }
    }

    // 递归后序遍历
    public void postOrder(BinaryTreeNode current) {
        if (current != null) {
            postOrder(current.llink);
            postOrder(current.rlink);
            System.out.print(current.info);
        }
    }

    // 非递归后序遍历
    public void notRecursivePostOrder() {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode current;
        current = root;
        while ((current != null) || (!stack.isEmpty())) {
            if (current != null) {
                current.isFirst = true;
                stack.push(current);
                current = current.llink;
            } else {
                current = stack.peek();
                stack.pop();
                if (current.isFirst) {
                    current.isFirst = false;
                    stack.push(current);
                    current = current.rlink;
                } else {
                    System.out.print(current.info);
                    current = null;
                }
            }
        }
    }

    // 树的层次遍历
    public void bfs() {
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode current;
        current = root;
        while ((current != null) || (!queue.isEmpty())) {
            if (current != null) {
                System.out.print(current.info);
                queue.add(current.llink);
                queue.add(current.rlink);
                current = queue.poll();
            } else {
                current = queue.poll();
            }
        }
    }

    public class BinaryTreeNode {
        private BinaryTreeNode llink = null;
        private BinaryTreeNode rlink = null;
        private int info;
        private boolean isFirst;

        public BinaryTreeNode(int info) {
            this.info = info;
        }
    }

    public void initTree() {
        root = new BinaryTreeNode(1);
        root.llink = new BinaryTreeNode(2);
        root.rlink = new BinaryTreeNode(3);
        root.llink.llink = null;
        root.llink.rlink = new BinaryTreeNode(4);
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.initTree();
        tree.preOrder(tree.getRoot());
        tree.nonRecursivePreOrder();
        tree.inOrder(tree.getRoot());
        tree.nonRecursiveInOrder();
        tree.postOrder(tree.getRoot());
        tree.notRecursivePostOrder();
        tree.bfs();
    }
}
