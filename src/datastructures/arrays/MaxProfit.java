package datastructures.arrays;

public class MaxProfit{

	  public static void main(String[] args){
//	    int[] stock = {2, -5, 5, 8, 100};
//	    System.out.println("Max. profit: "+maxProfitFromStock(stock, 0, 1));
		int[] stock = {100, 30, 15, 10, 8, 25, 80};
		System.out.println("Max profit: "+maxProfitBuySellTwice(stock));
	  }

	  public static int maxProfitFromStock(int[] prices){
	    int n = prices.length;
	    if(n == 0 || n == 1) return Integer.MIN_VALUE;

	    int minSoFar = prices[0];
	    int maxProfit = Integer.MIN_VALUE;
	    for(int i=1; i<n; i++){
	      maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
	      if(prices[i]<minSoFar){
	        minSoFar = prices[i];
	      }
	    }

	    return maxProfit;
	  }
	  
	  private static int maxProfitFromStock(int[] prices, int start, int end){
		  if(start == end) return 0;
		  
		  int minSoFar = prices[start];
		  int maxProfit = Integer.MIN_VALUE;
		  for(int i=start+1; i<=end; i++){
			  maxProfit = Math.max(maxProfit, prices[i]-minSoFar);
			  if(prices[i]<minSoFar){
				  minSoFar = prices[i];
			  }
		  }
		  
		  return (maxProfit == Integer.MIN_VALUE)? 0: maxProfit;
	  }
	  
	  private static int maxProfitBuySellTwice(int[] prices){
		  int n = prices.length;
		  if(n==0 || n==1) {
			  System.out.println("Hi!");
			  return Integer.MIN_VALUE;
		  }
		  
		  int maxProfit = Integer.MIN_VALUE;
		  for(int i=1; i<n-1; i++){
			  int trans1 = maxProfitFromStock(prices, 0, i);
			  int trans2 = maxProfitFromStock(prices, i+1, n-1);
			  maxProfit = Math.max(maxProfit, trans1+trans2);
		  }
		  
		  return (maxProfit == Integer.MIN_VALUE || maxProfit<0)? 0: maxProfit;
	  }
}

