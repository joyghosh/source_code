package algorithms.greedy;

/**
 * You are given n activities with their start and finish times. 
 * Select the maximum number of activities that can be performed by a single person,
 * assuming that a person can only work on a single activity at a time.
 * 
 * @author Joy Ghosh
 *
 */
public class ActivitySelection {

	public static void main(String[] args) {
	    int s[] =  {1, 3, 0, 5, 8, 5};
	    int f[] =  {2, 4, 6, 7, 9, 9};
	    selectActivity(s, f);
	}
	
	public static void selectActivity(int[] start, int[] end){
		System.out.println(0);
		int prev_finish = end[0]; 
		for(int i=1;i<end.length;i++){
			if(start[i] > prev_finish){
				System.out.println(i);
				prev_finish = end[i];
			}
		}
	}
}
