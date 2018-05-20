package problem_solving;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SimplestSum {

	private static final int divisor = (int)(Math.pow(10.0, 9.0) + 7.0);
	
    static int simplestSum(int k, int a, int b) {
        int S = 0;
        
        for(int i=a; i<=b; i++){
        	if(i<=k){
        		S+=1;
        	}else{
        		S += f(k, i, S);
        	}
        }
        return S%divisor;
    }
    
    static int f(int k, int n, int prevSum){
        int sum = 0;
        sum += prevSum + (n-1)*k;
//        for(int i=1; i<=n; i+=1){
//            sum += i;
//            i *= k;
//        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int k = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int result = simplestSum(k, a, b);
            System.out.println(result);
        }
        in.close();
    }
}