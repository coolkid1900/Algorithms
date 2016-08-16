package offer;

/**
 * Created by su on 16/8/10.
 */
public class FindNumsAppearOnce {

    public void Solution(int [] array,int num1[] , int num2[]) {
        if (array==null||array.length<2)
            return;
        int result=0;
        for (int item:array){
            result^=item;
        }
        int firstIndex=getFirstIndex(result);
        num1[0]=0;
        num2[0]=0;
        for (int item:array){
            if (isBit1(item,firstIndex)){
                num1[0]^=item;
            }else {
                num2[0]^=item;
            }
        }
        System.out.println(num1[0]+" "+num2[0]);
    }

    //得到n表示的二进制数中,从右到左第一个“1”所在的位置
    public int getFirstIndex(int n){
        int index=0;
        while ((n&1)==0&&index<32){
            n=n>>1;
            index++;
        }
        return index;
    }

    //判断数组中每个数的二进制表示中,从右到左第index位是否为“1”,从而将array分为两类
    public boolean isBit1(int n,int index){
        boolean check=false;
        n=n>>index;
        if ((1&n)==1){
            check=true;
        }
        return check;
    }


    public static void main(String[] args) {
        int[] array={1,2,4,3,3,1,2,5};
        FindNumsAppearOnce findNumsAppearOnce=new FindNumsAppearOnce();
        findNumsAppearOnce.Solution(array,new int[]{0},new int[]{0});
    }
}
