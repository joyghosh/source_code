package problem_solving;

public class BinaryStringProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "011";
		System.out.println(valueOfKthChar(str, 0, 1));
	}
	
	private static char valueOfKthChar(String binStr, int k, int m){
		StringBuilder sb = null;
		while(m>0){
			sb = new StringBuilder();
			for(int i=0; i<binStr.length(); i++){
				if(binStr.charAt(i) == '0'){
					sb.append("01");
				}else if(binStr.charAt(i) == '1'){
					sb.append("10");
				}
			}
			binStr = sb.toString();
			--m;
		}
		System.out.println(binStr);
		return binStr.charAt(k);
	}
}
