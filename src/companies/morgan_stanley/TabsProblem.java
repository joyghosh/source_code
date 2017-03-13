package companies.morgan_stanley;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TabsProblem {

	private static Stack<String> tabs;
	private static Map<String, Boolean> status;
	
	public static void main(String[] args) {
		tabs = new Stack<String>();
		status = new HashMap<String, Boolean>();
		
		//open and close tabs.
		System.out.println("open tab "+openNewTab("2"));
		System.out.println("open tab "+openNewTab("3"));
		System.out.println("open tab "+openNewTab("1"));
		System.out.println("open tab "+openNewTab("2"));
		System.out.println("previous tab "+closeTab("2"));
		System.out.println("open tab "+openNewTab("4"));
		System.out.println("open tab "+openNewTab("5"));
		System.out.println("previous tab "+closeTab("5"));
		System.out.println("previous tab "+closeTab("4"));
		System.out.println("previous tab "+closeTab("1"));
		System.out.println("open tab "+openNewTab("1"));
	}
	
	//Returns the closed tab or null.
	private static String closeTab(String tab){
		if(tabs.isEmpty()) return null;
		
		if(tabs.peek().equals(tab)){
			if(status.get(tab)){
				status.put(tab, false);
				tabs.pop();
				System.out.println(tab+" was closed.");
			}else{
				System.out.println(tab+" is already closed. Removing from stack.");
				tabs.pop();
			}
			
			if(!tabs.isEmpty()){
				return tabs.peek();
			}
		}
		
		return null;
	}
	
	/**
	 * Open a new tab and change it's status accordingly.
	 * @param tab
	 */
	private static String openNewTab(String tab){
			status.put(tab, true);
			return tabs.push(tab);
	}
}