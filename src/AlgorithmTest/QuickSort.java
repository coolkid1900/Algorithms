package AlgorithmTest;

/**
 * Created by su on 16/5/25.
 */

import java.util.Random;

/**
 * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 * 平均情况下时间复杂度均为O(NlogN),最坏情况下时间复杂度均为O(N²),为不稳定排序。
 */
public class QuickSort {

    public static void sort(int[] a,int low,int high){
        if (high<=low) return;
        int k=partition(a,low,high);
        sort(a,low,k-1);
        sort(a,k+1,high);
    }

    public static int partition(int[] a,int low,int high){
        int i=low;// 左侧指针
        int j=high+1;// 右侧指针
        int temp=a[low];// 以第一个数作为基准数
        while (true){
            // 从右向左寻找比基准数小的数,找到则结束循环,否则循环查找
            while (temp<a[--j]){
                if (j==low) break;
            }
            // 从左向右寻找比基准数大的数,找到则结束循环,否则循环查找
            while (temp>a[++i]){
                if (i==high) break;
            }
            // 左右指针相遇则退出循环,否则交换左右指针所指的数据
            if (i>=j) break;
            int t=a[j];
            a[j]=a[i];
            a[i]=t;

        }
        //左右指针相遇后,交换相遇点j和基准值位置的数据,保证基准点左侧数据全部小于基准数,右侧数据全部大于基准数
        int t=a[j];
        a[j]=a[low];
        a[low]=t;
        //返回基准点
        return j;
    }

    public static void main(String[] args) {
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
}
