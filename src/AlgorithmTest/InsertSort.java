package AlgorithmTest;

/**
 * Created by su on 16/5/24.
 */

import java.util.Random;

/**
 *从数组首位开始,依次比较第i位前相邻两位的大小,逐步将第i位数据放在合适的位置
 * 和冒泡排序相同,平均情况和最坏情况下时间复杂度为O(N²),最好情况为O(N),空间复杂度为O(1),为稳定排序
 */
public class InsertSort {
    public static void sort(int[] a){
        for (int i=0;i<a.length;i++){
            for (int j=i;j>0;j--){
                if (a[j-1]>a[j]){
                    int temp=a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                }
            }
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
        System.out.println("插入排序执行时间"+(end-start)+"ms");
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
