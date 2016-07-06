package algorithms.greedy;

import java.util.Arrays;

public class JobSequencing1 {

	public static void main(String[] args) {
		
		Job[] jobs = new Job[4];
		jobs[0] = new Job('a', 4, 20);
		jobs[1] = new Job('b', 1, 10);
		jobs[2] = new Job('c', 1, 40);
		jobs[3] = new Job('d', 1, 30);
		
		sequenceJobs(jobs);
	}
	
	private static void sequenceJobs(Job[] jobs){
		
		mergeSort(jobs, 0, jobs.length-1);	//sort the jobs in descending order of their profits.
		int[] result = new int[jobs.length];
		boolean[] slots = new boolean[jobs.length];
		
		for(int i=0;i<jobs.length;i++){
			for(int j= Math.min(jobs.length, jobs[i].deadline)-1;
					j>=0;--j){
				if(!slots[j]){
					result[j] = i;
					slots[j] = true;
					break;
				}
			}
		}
		
		for(int i=0;i<jobs.length;i++){
			if(slots[i]){
				System.out.println(jobs[result[i]].id);
			}
		}
	}
	
	/**
	 * merge-sort of jobs.
	 * @param jobs
	 * @param l
	 * @param r
	 */
	private static void mergeSort(Job[] jobs, int l, int r){
		if(l<r){
			int m = l + (r-l)/2;
			mergeSort(jobs, l, m);
			mergeSort(jobs, m+1, r);
			merge(jobs, l, m, r);
		}
	}
	
	/**
	 * merge step of ,erge sort.
	 * @param arr
	 * @param l
	 * @param m
	 * @param r
	 * @return
	 */
	private static Job[] merge(Job[] arr, int l, int m, int r){
		
		int c1, c2, c3;
		int n1 = (m-l)+1;		//Size of the left sub-array.
		int n2 = r-m;			//Size of the right sub-array.
		
		//create and initialize the sub-arrays.
		Job[] left = new Job[n1];
		Job[] right = new Job[n2];
		
		for(c1=0; c1<n1;c1++){
			left[c1] = arr[l+c1];
		}
		
		for(c2=0; c2<n2;c2++){
			right[c2] = arr[m+1+c2];
		}
		
		//reset the counter values.
		c1 = c2 = c3 = 0;
		
		while(c1<n1 && c2<n2){
			if(left[c1].compareTo(right[c2]) <= 0){
				arr[c3++] = left[c1++];
			}else{
				arr[c3++] = right[c2++];
			}
		}
		
		//put remaining elements of arr1  
		while(c1<n1){
			arr[c3++] = left[c1++];
		}
		
		//put remaining elements of arr2
		while(c2<n2){
			arr[c3++] = right[c2++];
		}
		
		//return the merged array.
		return arr;
	}
}

/**
 * The Job entity.
 *
 */
class Job implements Comparable<Job>{
	char id;
	int deadline;
	int profit;
	
	public Job(char id, int deadline, int profit){
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}

	@Override
	public int compareTo(Job o) {
		//for ascending order.
		//return (this.profit - o.profit);
		
		//for descending order.
		return (o.profit - this.profit);
	}
}
