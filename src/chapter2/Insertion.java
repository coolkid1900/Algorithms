package chapter2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//插入排序
public class Insertion {

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

		for(int i=1;i<c.length;i++){
			for(int j=i;j>0;j--){
				if(compare(c[j], c[j-1])){
					exchange(c, j, j-1);
				}
			}
		}
	}
	
	private static boolean compare(String a,String b){
		return a.compareTo(b)<0;				
	}
	
	private static void exchange(String[] c,int a,int b){
		String k=c[a];
		c[a]=c[b];
		c[b]=k;
	}

}
