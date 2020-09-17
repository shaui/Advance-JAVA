package collections_operation;

import java.util.PriorityQueue;

public class MyPriorityQueue {

	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue();
		pq.offer("Element 1");
		pq.offer("Element 2");
		pq.offer("Element 0"); //it will order it by natural ordering automatic
		System.out.println("Original PriorityQueue : " + pq);
		System.out.println("\"Pool\" : " + pq.poll());
		System.out.println("\"Peek\" : " + pq.peek());
		System.out.println("Queue Size : " + pq.size());
		pq.clear();
		System.out.println("After clear the Queue : " + pq);
		
	}

}
