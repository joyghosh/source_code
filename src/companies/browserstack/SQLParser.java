//package companies.browserstack;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * SQL parsing problem.
// * @author Joy Ghosh
// * 
// */
//public class SQLParser {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String line = null;
//		String[] tokens;
//		tokens = sc.nextLine().split(",");
//		
//		int N = Integer.parseInt(tokens[0]);	//no. of entities.
//		int M = Integer.parseInt(tokens[1]); 	//no. of where clauses.
//		
//		String[] attrs = sc.nextLine().split(",");
//		
//		//Create the entities.
//		List<Entity> entities = new ArrayList<Entity>();
//		for(int i=0;i<N; i++){
//			tokens = sc.nextLine().split(",");
//			Entity e = new Entity();
//			for(int j=0; j<attrs.length; j++){
//				e.set(attrs[j], tokens[j]);
//			}
//			
//			entities.add(e);
//		}
//		
//		//Where clauses.
//		for(int i=0; i<M; i++){
//			
//		}
//	}
//
//	public static boolean lessThan(Entity e, String key, String value){
//		
//	}
//}
