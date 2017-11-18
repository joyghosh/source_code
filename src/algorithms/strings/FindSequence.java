package algorithms.strings;

public class FindSequence{

	  public static void main(String[] args){
	    char[] letters = {'a', 'b', 'c'};
	    String str = "bbabcccaabc";
	    int result = findSequence(str, letters);
	    if(result!=-1){
	      System.out.println("Sequence found starting at index: "+result);
	    }else{
	      System.out.println("No such sequence present.");
	    }
	  }

	  public static int findSequence(String str, char[] letters){
	      int m = letters.length;
	      int n = str.length();
	      int k = 0;

	      for(int i=0; i<n-m+1; ){
	          for(k=0; k<3; k++){
	            if(str.charAt(i) != letters[k]){
	              break;
	            }else{
	            	i++;
	            }
	          }

	          if(k==3) return i;
	          i++;
	      }
	      return -1;
	  }
	}
