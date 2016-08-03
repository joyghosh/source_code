package adt.stack;

/**
 * The Stock Span Problem
 * The stock span problem is a financial problem where we have a series of n daily price 
 * quotes for a stock and we need to calculate span of stock’s price for all n days.The
 * span Si of the stock’s price on a given day i is defined as the maximum number of 
 * consecutive days just before the given day, for which the price of the stock on the 
 * current day is less than or equal to its price on the given day. For example, if an array of 7 days 
 * prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 * 
 * @author Joy Ghosh
 *
 */
public class StockSpanProblem {

	public static void main(String[] args) {
		int[] stocks = {100, 80, 60, 70, 60, 75, 85};
		int[] span = stockSpanSimple(stocks);
		printSpan(span);
	}
	
	/**
	 * Time-complexity: O(n^2).
	 * Space-complexity: O(n).
	 * @param stocks
	 * @return
	 */
	public static int[] stockSpanSimple(int[] stocks){
		
		int[] span = new int[stocks.length];
		for(int i=0;i<stocks.length;i++){
			for(int j=i;j>=0;j--){
				if(stocks[j] <= stocks[i]){
					++span[i];
				}else{
					break;
				}
			}
		}
		return span;
	}
	
	/**
	 * Print utility method.
	 * @param arr
	 */
	public static void printSpan(int[] arr){
		System.out.println("Stock span array.");
		for(int i:arr){
			System.out.printf("%d ", i);
		}
	}
}
