package nowcoder;

/**
 * Created by su on 16/8/2.
 */
public class Finder {
    public int findKth(int[] a,int n,int K){
        sort(a,0,n-1);
        return a[n-K];
    }

    public void sort(int[] a,int low,int high){
        if (low>=high) return;
        int k=partition(a,low,high);
        sort(a,low,k-1);
        sort(a,k+1,high);
    }

    public int partition(int[] a,int low,int high){
        int i=low;
        int j=high+1;
        int temp=a[low];
        while (true){
            while (temp<a[--j]){
                if (j==low) break;
            }
            while (temp>a[++i]){
                if (i==high) break;
            }
            if (i>=j) break;
            swap(a,j,i);
        }
        swap(a,j,low);
        return j;
    }

    public void swap(int[] a,int i,int j){
        int temp=a[j];
        a[j]=a[i];
        a[i]=temp;
    }

    public static void main(String[] args) {
        int[] a={1,3,5,2,2};
        Finder finder=new Finder();
        finder.findKth(a,a.length,3);
    }
}
