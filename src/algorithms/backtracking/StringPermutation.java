package algorithms.backtracking;

public class StringPermutation {

	public static void main(String[] args) {
		String str = "AABC";
		printPermutations(str.toCharArray(), 0, str.length()-1);
	}
	
	public static void printPermutations(char[] str, int l, int r){
		if(l==r){
			System.out.println(str);
		}else{
			for(int i=l; i<=r; i++){
				swap(str, l, i);
				printPermutations(str, l+1, r);
				swap(str, l, i);
			}
		}
	}
	
	public static void swap(char[] str, int i, int j){
		char tmp = str[i];
		str[i] = str[j];
		str[j] = tmp;
	}
	
	public static void printDistinctPermutations(char[] str){
		
	}
	
	public static int findCeilCharIndex(char[] str, char firstChar, int l, int h){
		int ceilIdx = l;
		for(int i=l+1; i<=h; i++){
			if(str[i]>firstChar && str[i]<str[ceilIdx]){
				ceilIdx = i;
			}
		}
		
		return ceilIdx;
	}
}
