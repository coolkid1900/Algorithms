package AlgorithmTest;

/**
 * Created by su on 16/5/24.
 */

import java.util.Random;

/**
 * 希尔排序是插入排序的一种,把记录按步长gap分组,对每组记录采用直接插入排序方法进行排序。
 * 随着步长逐渐减小,所分成的组包含的记录越来越多,当步长的值减小到1时,整个数据合成为一组,构成一组有序记录,则完成排序。
 * 使用希尔增量时最坏情况时间复杂度为O(N²),为不稳定排序
 */
public class ShellSort {
    public static void sort1(int[] a){
        int j;
        for (int gap = a.length/2; gap>0; gap/=2)
            for (j = gap;j < a.length;j++)//从数组第gap个元素开始
                if (a[j]< a[j - gap])//每个元素与自己组内的数据进行直接插入排序
                {
                    int temp = a[j];
                    int k = j - gap;
                    while (k >= 0 && a[k] > temp)
                    {
                        a[k + gap] = a[k];
                        k -= gap;
                    }
                    a[k + gap] = temp;
                }
    }

    //最好理解
    public static void sort2(int[] a){
        for (int gap=a.length;gap>0;gap/=2){
            for (int i=gap;i<a.length;i++){
                for (int j=i;j>=gap&&a[j-gap]>a[j];j-=gap){
                    int temp=a[j];
                    a[j]=a[j-gap];
                    a[j-gap]=temp;
                }

            }
        }
    }

    public static void sort3(int[] a){
        int j;
        for (int gap=a.length;gap>0;gap/=2){
            for (int i=gap;i<a.length;i++){
                int temp=a[i];
                for (j=i;j>=gap&&a[j-gap]>temp;j-=gap){
                    a[j]=a[j-gap];
                }
                //j已经经历j=j-gap
                a[j]=temp;
            }
        }
    }



    public static void main(String[] args) {
        int[] a=new int[10001];
        Random random=new Random();
        for (int i=0;i<10001;i++){
            int temp=random.nextInt(10000);
            a[i]=temp;
        }
        int[] b=a;
        int[] c=a;
        long start1=System.currentTimeMillis();
        sort1(a);
        long end1=System.currentTimeMillis();
        System.out.println("Shell排序1执行时间"+(end1-start1)+"ms");
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println("");
        long start2=System.currentTimeMillis();
        sort2(b);
        long end2=System.currentTimeMillis();
        System.out.println("Shell排序2执行时间"+(end2-start2)+"ms");
        for (int i=0;i<b.length;i++){
            System.out.print(b[i]+" ");
        }
        System.out.println("");
        long start3=System.currentTimeMillis();
        sort3(c);
        long end3=System.currentTimeMillis();
        System.out.println("Shell排序3执行时间"+(end3-start3)+"ms");
        for (int i=0;i<c.length;i++){
            System.out.print(c[i]+" ");
        }
    }
}
