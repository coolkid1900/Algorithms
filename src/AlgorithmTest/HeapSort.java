package AlgorithmTest;

/**
 * Created by su on 16/5/25.
 */

import java.util.Random;

/**
 * 堆排序是选择排序的一种。可以利用数组的特点快速定位指定索引的元素。堆分为大根堆和小根堆，是完全二叉树。
 * 大根堆的要求是每个节点的值都不大于其父节点的值。在数组的非降序排序中，需要使用的就是大根堆，因为根据大根堆的要求可知，最大的值一定在堆顶。
 * 需要注意的是堆中的排序从1开始,而数组的排序从0开始,在对数组进行操作时需要对索引进行减1操作。
 * 时间复杂度所有情况下均为O(NlogN),空间复杂度为O(1),为稳定排序。
 */
public class HeapSort {
    public static void sort(int[] a){
        int N=a.length;
        // 建立堆,使堆有序化
        for (int k=N/2;k>=1;k--){
            sink(a,k,N);
        }
        while (N>1){
           // 交换第一位与最后一位的值,即将最大值后移,并将数组总数减1
           exchange(a,1,N--);
           // 重建剩余堆,恢复剩余堆有序化
           sink(a,1,N);
        }

    }

    public static void sink(int[] a,int k,int N){
        while(2*k<=N){
            int j=2*k;
            //锁定子节点中的最大值
            if (j<N&&less(a,j,j+1)) j++;
            //如果父节点小于子节点的最大值,则退出当前循环,否则交换父节点数据与子节点的最大值
            if (less(a,j,k)) break;
            exchange(a,j,k);
            k=j;
        }
    }

    public static void exchange(int[] a,int i,int j){
        int temp=a[i-1];
        a[i-1]=a[j-1];
        a[j-1]=temp;
    }

    public static boolean less(int[] a,int i,int j){
        return a[i-1]<a[j-1];
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
        System.out.println("堆排序执行时间"+(end-start)+"ms");
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
