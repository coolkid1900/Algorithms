package chapter2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Shell {

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
		int h=1;
		int N=c.length;
		while(h<N/3){
			h=3*h+1;
		}
		while(h>=1){
			for(int i=h;i<N;i++){
				for(int j=i;j>=h;j-=h){
					if(compare(c[j],c[j-h])){
						exchange(c,j,j-h);
					}
				}
			}
			h=h/3;
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
