package AlgorithmTest;

/**
 * Created by su on 16/5/24.
 */


import java.util.Random;

/**
 * 从数组首位开始,依次比较第i位和后面所有值的大小,通过对比选出最小值,将最小值与第i位进行交换
 * 时间复杂度所有情况下均为O(N²),空间复杂度为O(1),属于不稳定排序
 */

public class SelectionSort {

    public static void sort(int[] a){
        for (int i=0;i<a.length;i++){
            int min=i;
            for (int j=i+1;j<a.length;j++){
                if (a[min]>a[j]){
                    min=j;
                }
            }
            int temp=a[min];
            a[min]=a[i];
            a[i]=temp;
        }
    }

    public static void main(String[] args) {
        int[] a=new int[10000];
        Random random=new Random();
        for (int i=0;i<10000;i++){
            int temp=random.nextInt(10000);
            a[i]=temp;
        }
        long start=System.currentTimeMillis();
        sort(a);
        long end=System.currentTimeMillis();
        System.out.println("选择排序执行时间"+(end-start)+"ms");
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
