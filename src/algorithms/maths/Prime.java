package algorithms.maths;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++){
			int m = sc.nextInt();
			int n = sc.nextInt();
			for(int j=m; j<=n; j++){
				if(isPrime(j)){
					System.out.println(j);
				}
			}
			
			System.out.println();
		}
		
		sc.close();
	}

	public static boolean isPrime(int n){
		if(n <= 1)
			return false;
		if(n<=3)
			return true;
		
		for(int i=2;i<n; i++){
			if(n%i== 0)
				return false;
		}
		
		return true;
	}
}
