package offer;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by su on 16/8/10.
 *
 */
public class FindCharsAppearOnce {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        HashMap<Character,Integer> hashMap=new HashMap<>();
        while (scanner.hasNext()){
            String str=scanner.nextLine();
            for (int i=0;i<str.length();i++){
                if (hashMap.containsKey(str.charAt(i))){
                    int count=hashMap.get(str.charAt(i));
                    hashMap.put(str.charAt(i),++count);
                }else {
                    hashMap.put(str.charAt(i),1);
                }
            }
            for (int i=0;i<str.length();i++){
                char c=str.charAt(i);
                if (hashMap.get(c)==1){
                    System.out.println(c);
                    break;
                }
            }
            if (!hashMap.containsValue(1)){
                System.out.println(".");
            }
        }
    }
}
