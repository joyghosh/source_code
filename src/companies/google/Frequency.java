package companies.google;

import java.util.Scanner;

public class Frequency {

		public static void main(String[] args){
			
			int[] arr = {1,2,3,3,3,3,3,3,3,4};
			System.out.println("Enter the number to find occurrences: ");
			Scanner scanner = new Scanner(System.in);
			int value = scanner.nextInt();
			scanner.close();
			System.out.println("Frequency of "+value+ " in the sorted array is: "+countOccurences(arr, value));
		}
		
		/**
		 * Binary search.
		 * @param arr Array
		 * @param low lower index
		 * @param high higher index.
		 * @param key search key
		 * @return index of key.
		 */
		private static int binarySearch(int[] arr, int low, int high, int key){
			
				int mid = (low+high)/2;
				if(arr[mid] == key){
					return mid;
				}else if(arr[mid] < key){
					return binarySearch(arr, mid+1, high, key);
				}else{
					return binarySearch(arr, low, mid-1, key);
				}
		}
		
		private static int countOccurences(int[] arr, int key){
			
				int count = 0;
				int index = binarySearch(arr, 0, arr.length-1, key);
				count = 1 + countBackward(arr, index-1, key) + countForward(arr, index+1, key);
				return count;
		}
		
		private static int countBackward(int[] arr, int index, int key){
				
				int left = 0;
				while(index>=0){
					
					if(arr[index--] == key){
						++left;
						continue;
					}else{
						break;
					}
				}
				
				return left;
		} 
		
		private static int countForward(int[] arr, int index, int key){
			
			int right = 0;
			while(index < arr.length){
				
				if(arr[index++] == key){
					++right;
					continue;
				}else{
					break;
				}
			}
			
			return right;
		}
}
