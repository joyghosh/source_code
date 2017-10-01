package companies;

import java.util.Random;
import java.util.Scanner;

public class RandomString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the random string (n): ");
		int n = sc.nextInt();
		System.out.println(randString(n));
		sc.close();
	}
	
    private static String randString(int n){
        if(n==0) return null;
        
        char[] alphaNumeric = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
        		'N', 'O', 'P', 'Q','R','S','T','U','V','W','X','Y','Z',
        		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',  '1', '2', '3', '4', '5'};
        Random rand = new Random();
        
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<n; i++){
            int r = rand.nextInt(alphaNumeric.length);
            builder.append(alphaNumeric[r]);
        }
        
        return builder.toString();
    }
}
