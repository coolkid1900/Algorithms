package chapter2;

import java.util.Random;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Quick {

    public static void main(String[] args) {
//        int[] s = StdIn.readAllInts();
//        sort(s,0,s.length-1);
//        show(s);
        int[] a=new int[10000];
        Random random=new Random();
        for (int i=0;i<10000;i++){
            int temp=random.nextInt(10000);
            a[i]=temp;
        }
        long start=System.currentTimeMillis();
        sort(a,0,a.length-1);
        long end=System.currentTimeMillis();
        System.out.println("快速排序执行时间"+(end-start)+"ms");
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

    private static void sort(int[] s, int low, int high) {
        if(high<=low) return;
        int j=partition(s,low,high);
        sort(s,low,j-1);
        sort(s,j+1,high);
    }

    private static int partition(int[] s, int low, int high) {

        int i = low;
        int j = high+ 1;
        int v = s[low];
        while (true) {
            while (compare(v, s[--j])){
                if (j == low) break;
            }
            while (compare(s[++i], v)){
                if (i == high) break;
            }
            if (i >= j) break;
            exchange(s, i, j);
        }
        exchange(s, low, j);
        return j;
    }

    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
    }

    private static boolean compare(int a,int b){
        //a<b返回true
        return a<b;
    }

    private static void exchange(int[] c,int a,int b){
        //交换操作
        int k=c[a];
        c[a]=c[b];
        c[b]=k;
    }
}
