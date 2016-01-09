package com.ds.linkedlist;

import com.iq.common.Node;
import com.iq.common.Reference;

//Mergesort of singly linked list.
public class MergeSort{
       
      //merge sort.
      private static void mergeSort(Reference<Node> headref){
              
              //base case. if headref is null or has just one element.
              if(headref.get()==null || headref.get().next==null)
                  return;
              
              //split it in two halves.
              Reference<Node> a = null,b = null;
              frontBackSplit(headref, a, b);
              
              //sort the two halves.
              mergeSort(a);
              mergeSort(b);
              
              //merge the sorted halves and update the head reference.
              headref.set(sortedMerge(a, b));
      }
      
      //split a list into two halves and pass their head values as reference parameters.
      private static void frontBackSplit(Reference<Node> source, Reference<Node> front, 
    		  							  Reference<Node> back){
              
              //base case. len < 2 case.
              if(source.get() == null || source.get().next == null){
                  front.set(source.get());
                  back.set(null);
              }
                      
             //Slow and fast pointer strategies.
             Node slow = new Node(), fast = new Node();
             slow = source.get(); fast = source.get().next;
             
             while(fast!=null){
                 
                    fast = fast.next;
                    if(fast !=null){
                        slow = slow.next;
                        fast = fast.next;
                    }
             }       
             
             //split it into two. slow is before the middle.
             front.set(slow);
             back.set(slow.next);
             slow.next = null;
      }
      
      //merge two sorted lists.
      private static Node sortedMerge(Reference<Node> a, Reference<Node> b){
          
          //base case. either of the list is empty.
          if(a.get() == null){
              return b.get();
          }else if(b.get() == null){
              return a.get();
          }
          
          //for an alternative scenario.
          Node result = new Node();
          if(a.get().data <= b.get().data){
        	  result = a.get();
              result.next = sortedMerge(new Reference<Node>(a.get().next), b);
          }else{
              result = b.get();
              result.next = sortedMerge(a, new Reference<Node>(b.get().next));
          }
          
          return result;
      }
      
      //utility methods.
      private static void printList(Node head){
          
          Node node = head;
          while(node!=null){
              System.out.print(" "+node.data);
              node = node.next;
          }
      }
      
      //push a new node at the head of the singly linked list.
      private static Node pushNode(Node head, int data){
              Node new_node = new Node();
              new_node.data = data;
              new_node.next = head;
              head = new_node;
              
              return head;
      }
      
      //main method.
      @SuppressWarnings("null")
	public static void main(String[] args){
          
          System.out.println("Merge sort on single linked list.");

          //create a single linked list.
          
          Reference<Node> list1 = new Reference<Node>(new Node());
      
          list1.set(pushNode(list1.get(), 5));
          list1.set(pushNode(list1.get(), 10));
          list1.set(pushNode(list1.get(), 3));
          list1.set(pushNode(list1.get(), 30));
          list1.set(pushNode(list1.get(), 301));
          
          printList(list1.get());
          mergeSort(list1);
          System.out.println();
          printList(list1.get());    
      }
}
