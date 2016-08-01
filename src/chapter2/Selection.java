package chapter2;

import edu.princeton.cs.algs4.*;

//选择排序
public class Selection {

	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		sort(a);
		show(a);
	}

	private static void show(String[] a) {
		for (int i = 0; i < a.length; i++)
			StdOut.println(a[i]);
	}

	private static void sort(String[] c){
		for(int i=0;i<c.length;i++){
			int min=i;
			for(int j=i+1;j<c.length;j++){
				if(compare(c[j],c[min])){
					//循环查找最小值，不断的将最小值序号赋予min，继续进行比较，当内循环查找完成后，即可得出当轮最小值对应的序号
					min=j;
				}
				//退出内循环，交换最小值和外循环序号对应值的位置
				exchange(c,i,min);
			}
		}
	}

	private static boolean compare(String a,String b){
		//a<b返回true
		return a.compareTo(b)<0;
	}

	private static void exchange(String[] c,int a,int b){
		//交换操作
		String k=c[a];
		c[a]=c[b];
		c[b]=k;
	}
}
