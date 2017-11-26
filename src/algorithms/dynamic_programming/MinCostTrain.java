package algorithms.dynamic_programming;

public class MinCostTrain {

	private static final int INF = Integer.MAX_VALUE;
	private static final int N = 4;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cost[][] = { {0, 15, 80, 90},
                {INF, 0, 40, 50},
                {INF, INF, 0, 70},
                {INF, INF, INF, 0}
              };
		System.out.println("Min. cost to reach station "+N+" is "+minCostToTravel(cost));
	}
	
	public static int minCostToTravel(int[][] cost){
		return minCostToTravelRecur(cost, 0, N-1);
	}
	
	public static int minCostToTravelRecur(int[][] cost, int s, int d){
		//if source is equal to destination or
		//destination is next to source. 
		if(s==d || s+1==d) return cost[s][d];
		
		//Initialize min cost as direct ticket from source to destination.
		int min = cost[s][d];
		
		//Trying every intermediate destination or station.
		for(int i=s+1; i<d; i++){
			int c = minCostToTravelRecur(cost, s, i) + minCostToTravelRecur(cost, i, d);
			if(c<min){
				min = c;
			}
		}
		
		return min;
	}
}
