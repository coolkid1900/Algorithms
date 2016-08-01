package AlgorithmTest;

import java.util.Random;

/**
 * Created by su on 16/5/25.
 */

/**
 * 将两个（或两个以上）有序表合并成一个新的有序表,即把待排序序列分为若干个子序列,每个子序列是有序的,然后再把有序子序列合并为整体有序序列。
 * 所有情况下时间复杂度均为O(NlogN),为稳定排序。
 */
public class MergeSort {
    private static int[] aux;

    public static void sort1(int[] a,int low,int high){
        if (low>=high) return;
        int middle=(low+high)/2;
        sort1(a,low,middle);
        sort1(a,middle+1,high);
        merge1(a,low,middle,high);
    }

    public static void sort2(int[] a,int low,int high){
        if (low>=high) return;
        int middle=(low+high)/2;
        sort2(a,low,middle);
        sort2(a,middle+1,high);
        merge2(a,low,middle,high);
    }

    public static void merge1(int[] a,int low,int middle,int high){
        //原地归并
        int i = low;
        int j = middle+1;
        for (int k = low; k <= high; k++)
            aux[k] = a[k] ;
        for (int k = low; k <= high; k++)
            if (i > middle)
                a[k] = aux[j++] ;
            else if (j > high)
                a[k] = aux[i++] ;
            else if (aux[j]<aux[i])
                a[k] = aux[j++] ;
            else
                a[k] = aux[i++] ;
    }

    //最好理解
    public static void merge2(int[] a, int low, int middle, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = middle + 1;// 右指针
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= middle && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        // 把左边剩余的数移入数组
        while (i <= middle) {
            temp[k++] = a[i++];
        }

        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }

        // 把新数组中的数覆盖a数组
        for (int m = 0; m < temp.length; m++) {
            a[m + low] = temp[m];
        }
    }

    public static void main(String[] args) {
        int[] a=new int[10000];
        Random random=new Random();
        for (int i=0;i<10000;i++){
            int temp=random.nextInt(10000);
            a[i]=temp;
        }
        int[] b=a;
        aux=new int[a.length];
        long start1=System.currentTimeMillis();
        sort1(a,0,a.length-1);
        long end1=System.currentTimeMillis();
        System.out.println("归并排序1执行时间"+(end1-start1)+"ms");
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println("");
        long start2=System.currentTimeMillis();
        sort2(b,0,b.length-1);
        long end2=System.currentTimeMillis();
        System.out.println("归并排序2执行时间"+(end2-start2)+"ms");
        for (int i=0;i<b.length;i++){
            System.out.print(b[i]+" ");
        }
    }
}
