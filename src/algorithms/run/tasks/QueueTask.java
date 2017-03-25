/**
 *  
 */
package algorithms.run.tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import algorithms.datastructures.interfaces.MyQueue;
import algorithms.run.results.Result;
import algorithms.run.results.interfaces.MyResult;
import algorithms.run.tasks.interfaces.MyTask;
import algorithms.run.utils.PrintUtils;

/**
 * @author Andrea Ranieri
 * @email and.ranieros@gmail.com
 */
public class QueueTask implements MyTask {

	private List<Integer> taskRealResult;
	private String name;
	private MyResult result;
	private MyQueue<Integer> queue;

	public QueueTask(MyQueue<Integer> queue, String name) {
		this.queue = queue;
		this.name = name;
		this.taskRealResult = new ArrayList<Integer>();
		this.result = new Result(this.name);
	}

	public void runTask() {
		Scanner scanInput = null;
		try {
			scanInput = new Scanner(new FileInputStream(new File("inputdata/MyQueue/Input1")));
			result.start();
			int n = scanInput.nextInt();
			PrintUtils pu = new PrintUtils('*', 10, 100);
			for (int i = 0; i < n; i++) {
				int operation = scanInput.nextInt();
				if (operation == 1) { // enqueue
					this.queue.enqueue(scanInput.nextInt());
				} else if (operation == 2) { // dequeue
					this.queue.dequeue();
				} else if (operation == 3) { // print/peek
					this.taskRealResult.add(this.queue.peek());
					System.out.print(pu.running());
				}
			}
			result.end();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			return;
		} finally {
			if (scanInput != null)
				scanInput.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * algorithms.run.tasks.interfaces.MyTask#checkCorrectness(algorithms.run.
	 * results.interfaces.MyResult)
	 */
	@Override
	public void checkCorrectness() {
		Scanner scanOutput = null;
		try {
			scanOutput = new Scanner(new FileInputStream(new File("inputdata/MyQueue/Output1")));
			int i = 0;
			int read = 0;
			int real = 0;
			while (scanOutput.hasNext()) {
				real = this.taskRealResult.get(i++);
				read = scanOutput.nextInt();
				if (real != read) {
					this.result.setSuccess(false);
					break;
				} else {
					this.result.setSuccess(true);
				}
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			if (scanOutput != null)
				scanOutput.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see algorithms.run.tasks.interfaces.MyTask#printResult()
	 */
	@Override
	public void printResult() {
		System.out.println(this.result.toString());
	}
}
