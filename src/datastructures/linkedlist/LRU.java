//package datastructures.linkedlist;
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Map;
//
///**
// * Created by joyghosh on 12/05/18.
// */
//public class LRU {
//
//    Map<Integer, Node> lookup;
//    LinkedList<Node> queue;
//
//    int capacity;
//    int currentSize;
//
//    public LRU(int capacity){
//        this.capacity = capacity;
//        this.lookup = new HashMap<Integer, Node>();
//        this.queue = new LinkedList<Node>();
//    }
//
//    public void refer(Integer pageNo){
//        if(!lookup.containsKey(pageNo)){
//            System.out.println("Page frame no in the LRU cache. Fetching from memory.");
//            enqueue(pageNo);
//        }
//
//        Node n = lookup.get(pageNo);
//
//        if(!queue.peekFirst().pageNo.equals(pageNo)){
//            queue.remove(n);
//            queue.addFirst(n);
//        }
////        else if(){
////
////        }
////    }
////
////    public void enqueue(Integer page){
////        if(currentSize == capacity){
////            queue.removeLast();
////        }
////
////        queue.addFirst(page);
////
////        if(currentSize == 0){
////
////        }
////    }
////
////    public static class Node{
////        Integer pageNo;
////
////    }
//}
