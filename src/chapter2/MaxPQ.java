package chapter2;

import edu.princeton.cs.algs4.StdIn;

/**
 * Created by su on 16/4/19.
 */
public class MaxPQ {
    private int[] pq;
    private int N;

    public MaxPQ(int maxN){
        pq=new int[maxN+1];
    }

    public void insert(int v){
        pq[++N]=v;
        swim(N);
    }

    public int delMax(){
        int max=pq[1];
        exch(1,N--);
        pq[N+1]=0;
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    private boolean less(int i, int j) {
        return pq[i]<pq[j];
    }


}

