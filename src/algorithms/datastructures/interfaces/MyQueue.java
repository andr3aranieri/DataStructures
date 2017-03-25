/**
 *  
 */
package algorithms.datastructures.interfaces;

/**
 *  @author Andrea Ranieri
 *  @email  and.ranieros@gmail.com	
 */
public interface MyQueue<T> {
	public void enqueue(T value);
	public T dequeue();
	public T peek();
}
