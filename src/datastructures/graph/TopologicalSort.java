package datastructures.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class TopologicalSort{
    
    private static int V;    //no of vertices.
    private static LinkedList<Integer> adj[];    //Adjacency list.
    
    public TopologicalSort(int V){
        TopologicalSort.V = V;
        TopologicalSort.adj = new LinkedList[V];
        for(int i=0; i<V; i++){
            adj[i] = new LinkedList<Integer>();
        }
    }
    
    private static void addEdge(int u, int v){
        adj[u].add(v);
    }
    
    private static void topologicalSortUtil(int v, Boolean[] visited, Stack stack){
            //mark the vertex as visited.
            visited[v] = true;
            Integer i;
            
            ListIterator<Integer> itr = adj[v].listIterator();
            while(itr.hasNext()){
                i = itr.next();
                if(!visited[i]){
                    topologicalSortUtil(i, visited, stack);
                }
            }
            
            //push the current vertex onto the stack.
            stack.push(new Integer(v));
    }
    
    private static void topologicalSort(){
         
          Stack stack = new Stack();
          Boolean[] visited = new Boolean[V];
          
          for (int i = 0; i < V; i++)
              visited[i] = false;
          
          for(int i=0; i<V; i++){
              if(!visited[i]){
                  topologicalSortUtil(i, visited, stack);
              }
          }
          
          //print the contents of the stack.
          while(!stack.empty()){
              System.out.print(stack.pop()+" ");
          }
    }
    
    public static void main(String[] args){
         TopologicalSort ts = new TopologicalSort(6);
         ts.addEdge(5, 2);
         ts.addEdge(5, 0);
         ts.addEdge(4, 0);
         ts.addEdge(4, 1);
         ts.addEdge(2, 3);
         ts.addEdge(3, 1);
 
        System.out.println("Following is a Topological " +
                           "sort of the given graph");
        ts.topologicalSort();
    }
}