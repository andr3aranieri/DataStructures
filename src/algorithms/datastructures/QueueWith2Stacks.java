/**
 *  
 */
package algorithms.datastructures;

import java.util.Collections;
import java.util.Stack;

import algorithms.datastructures.interfaces.MyQueue;

/**
 * @author Andrea Ranieri
 * @email and.ranieros@gmail.com
 */
public class QueueWith2Stacks<T> implements MyQueue<T> {

	private Stack<T> stackNewestOnTop = new Stack<T>();
	private Stack<T> stackOldestOnTop = new Stack<T>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * algorithms.datastructures.interfaces.MyQueue#enqueue(java.lang.Object)
	 */
	@Override
	public void enqueue(T value) {
		this.stackNewestOnTop.push(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see algorithms.datastructures.interfaces.MyQueue#dequeue()
	 */
	@Override
	public T dequeue() {
		this.invertStacks();
		return this.stackOldestOnTop.pop();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see algorithms.datastructures.interfaces.MyQueue#peek()
	 */
	@Override
	public T peek() {
		this.invertStacks();
		return this.stackOldestOnTop.peek();
	}

	private void invertStacks() {
		if (this.stackOldestOnTop.empty()) {
			Collections.reverse(this.stackNewestOnTop);
			this.stackOldestOnTop.addAll(this.stackNewestOnTop);
			this.stackNewestOnTop.clear();
		}
	}
}
