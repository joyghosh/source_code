package companies.yahoo;

public class AddLinkedLists {

	public static void main(String[] args) {
		
	}
	
	private static Node sum(Node first, Node second){
		//base conditions.
		if(first == null && second == null) return null;
		if(first == null) return second;
		if(second == null) return first;
		
		Node result = null;
		int carry = 0;
		int sum = 0;
		while(first!=null || second!=null){
			if(first == null){
				sum = carry+second.data;
				if(sum>10){
					sum = sum - 10;
					carry = 1;
				}else{
					
				}
				if(result == null){
					result = new Node(second.data);
				}else{
					result.next = new Node(second.data);
					result = result.next;
				}
				second = second.next;
			}else if(second == null){
				if(result == null){
					result = new Node(first.data);
				}else{
					result.next = new Node(first.data);
					result = result.next;
				}
				first = first.next;
			}else{
				
			}
		}
		
		return null;
	}
}
