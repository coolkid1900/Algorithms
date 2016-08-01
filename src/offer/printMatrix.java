package offer;

import java.util.ArrayList;

import edu.princeton.cs.algs4.Count;

/**
 * Created by su on 16/5/18.
 */
public class printMatrix {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> Solution(int [][] matrix) {
        ArrayList<Integer> integers=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        int count=(Math.min(m,n)-1)/2+1;
        for (int i=0;i<count;i++){
            for (int j=i;j<n-i;j++){
                integers.add(matrix[i][j]);
            }
            for (int j=i+1;j<m-i;j++){
                integers.add(matrix[j][n-1-i]);
            }
            for (int j=n-i-2;j<0;j++){

            }
        }
        return integers;
    }
}
