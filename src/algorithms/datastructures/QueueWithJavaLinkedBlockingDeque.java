/**
 *  
 */
package algorithms.datastructures;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import algorithms.datastructures.interfaces.MyQueue;

/**
 * @author Andrea Ranieri
 * @email and.ranieros@gmail.com
 */
public class QueueWithJavaLinkedBlockingDeque<T> implements MyQueue<T> {

	private Queue<T> queue;

	public QueueWithJavaLinkedBlockingDeque() {
		this.queue = new LinkedBlockingDeque<T>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * algorithms.datastructures.interfaces.MyQueue#enqueue(java.lang.Object)
	 */
	@Override
	public void enqueue(T value) {
		this.queue.add(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see algorithms.datastructures.interfaces.MyQueue#dequeue()
	 */
	@Override
	public T dequeue() {
		return this.queue.poll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see algorithms.datastructures.interfaces.MyQueue#peek()
	 */
	@Override
	public T peek() {
		return this.queue.peek();
	}

}
