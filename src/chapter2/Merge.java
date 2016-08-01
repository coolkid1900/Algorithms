package chapter2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Merge{
	private static String[] aux;

	public static void main(String[] args) {
		String[] s = StdIn.readAllStrings();
		sort(s,0,s.length-1);
		show(s);
	}

	private static void show(String[] a) {
		for (int i = 0; i < a.length; i++)
			StdOut.println(a[i]);
	}

	private static void sort(String[] s,int low,int high){
		if(high<=low) return;
		int mid=(low+high)/2;
		sort(s,low,mid);
		sort(s,mid+1,high);
		merge(s,low,mid,high);
	}


	public static void merge(String[] s,int low,int mid,int high){
/*		 // 临时数组
        String[] tmpArr = new String[s.length];
        // 左数组第一个元素索引
        int i =low ;
        // 右数组第一个元素索引
        int j = mid + 1;
        // 临时第一个元素的索引
        int tmp = low;
        while (i <= mid && j <= high) {
            // 从两个数组中取出最小的放入临时数组
            if (compare(s[i],s[j])) {
                tmpArr[tmp++] = s[i++];
            } else {
                tmpArr[tmp++] = s[j++];
            }
        }
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while (j <= high) {
            tmpArr[tmp++] = s[j++];
        }
        while (i <= mid) {
            tmpArr[tmp++] = s[i++];
        }
        // 将临时数组中的内容拷贝回原数组中
        // （原left-right范围的内容被复制回原数组）
        while (low <= high) {
            s[low] = tmpArr[low++];
        }  */

		//原地归并
		int i = low, j = mid+1;
		aux=new String[s.length];
		for (int k = low; k <= high; k++)
			aux[k] = s[k] ;
		for (int k = low; k <= high; k++)
			if (i > mid)
				s[k] = aux[j++] ;
			else if (j > high)
				s[k] = aux[i++] ;
			else if (compare(aux[j],aux[i]))
				s[k] = aux[j++] ;
			else
				s[k] = aux[i++] ;
	}


	private static boolean compare(String a,String b){
		//a<b返回true
		return a.compareTo(b)<0;
	}
}