package chapter3;

import chapter2.MaxPQ;
import com.sun.tools.hat.internal.model.Root;
import edu.princeton.cs.algs4.StdIn;

/**
 * Created by su on 16/4/20.
 */
public class test<Key extends Comparable<Key>,Value>{
    private Node root;

    private class Node{
        private Key key;
        private Value value;
        private Node left,right;
        private int N;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }


    }

    public static void main(String[] args) {
        test<String, Integer> test = new test<>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            test.put(key, i);
        }

//        test.deleteMin();
        test.delete("e");
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.value   = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    private Value get(Key key){
        return get(root,key);
    }

    private Value get(Node node,Key key){
        if (node==null)
            return null;
        int cmp=key.compareTo(node.key);
        if (cmp>0)
            return get(node.right,key);
        else if (cmp<0)
            return get(node.left,key);
        else return node.value;
    }


    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    private Key min(){
        return min(root).key;
    }

    private Node min(Node node){
        if (node.left==null) return node;
        return min(node.left);
    }

    private Key max(){
        return max(root).key;
    }

    private Node max(Node node){
        if (node.right==null) return node;
        return max(node.right);
    }

    private void deleteMin(){
        root=deleteMin(root);
    }

    private Node deleteMin(Node node){
        if (node.left==null) {
            return node.right;
        }
        node.left=deleteMin(node.left);
        node.N=size(node.left)+size(node.right)+1;
        return node;
    }

    private void delete(Key key){
        root=delete(root,key);
    }

    private Node delete(Node node,Key key){
        if (node==null) return null;
        int cmp=key.compareTo(node.key);
        if (cmp<0){
            node.left=delete(node.left,key);
        }else if (cmp>0){
            node.right=delete(node.right,key);
        }else {
            if (node.right==null){
                return node.left;
            }
            if (node.left==null){
                return node.right;
            }
            Node t=node;
            node=min(t.right);
            node.right=deleteMin(t.right);
            node.left=t.left;
        }
        node.N=size(node.right)+size(node.left)+1;
        return node;

    }
}
