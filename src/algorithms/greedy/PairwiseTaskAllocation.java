package algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PairwiseTaskAllocation {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		List<Integer> taskDurations = new ArrayList<>();
		if(N%2 == 0){
			for(int i=0; i<N; i++){
				taskDurations.add(s.nextInt());
			}
			
			System.out.println("Allocating tasks.");
			List<PairedTask> optimalTasks = optimumTaskAssignment(taskDurations);
			
			for(PairedTask task: optimalTasks){
				System.out.println("("+task.task1 + "," + task.task2 + ")");
			}
		}else{
			System.out.println("Odd number of tasks. Pair allocation isn't possible.");
		}
		s.close();
	}
	
	public static class PairedTask{
		Integer task1;
		Integer task2;
		
		public PairedTask(Integer task1, Integer task2){
			this.task1 = task1;
			this.task2 = task2;
		}
	}
	
	public static List<PairedTask> optimumTaskAssignment(List<Integer> taskDurations){
		Collections.sort(taskDurations);
		List<PairedTask> optimumTaskAllocations = new ArrayList<>();
		for(int i=0, j= taskDurations.size()-1; i<j; i++, j--){
			optimumTaskAllocations.add(new PairedTask(taskDurations.get(i), taskDurations.get(j)));
		}
		
		return optimumTaskAllocations;
	}
}
