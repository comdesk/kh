package temp23;

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int i = 0; i < q; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int sum = 0;
          
            for(int j = 0; j < n; j++) {
            	sum = sum + (int)(Math.pow(2, j)) * b;
            	
            	int result = a + sum;
            	
                System.out.print(result + " ");
            } //in for
            
        } //out for
        in.close();
    } //main
//    
//    public static void main(String []argh){
//        Scanner in = new Scanner(System.in);
//        int q = in.nextInt();
//        for(int i = 0; i < q; i++){
//            int a = in.nextInt();
//            int b = in.nextInt();
//            int n = in.nextInt();
//         
////            int[] intArr
//        } //for
//        in.close();
//    } //main
} //end class





