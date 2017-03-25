/**
 *  
 */
package algorithms.run;

import java.util.Scanner;

import algorithms.datastructures.QueueWith2Stacks;
import algorithms.datastructures.QueueWithJavaConcurrentLinkedQueue;
import algorithms.datastructures.QueueWithJavaLinkedBlockingDeque;
import algorithms.datastructures.QueueWithJavaLinkedBlockingQueue;
import algorithms.datastructures.QueueWithJavaLinkedTransferQueue;
import algorithms.datastructures.interfaces.MyQueue;
import algorithms.run.tasks.QueueTask;
import algorithms.run.tasks.interfaces.MyTask;

/**
 * @author Andrea Ranieri
 * @email and.ranieros@gmail.com
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome. Commands:");
		System.out.println("   1 --> Test Queue with 2 stacks implementation;");
		System.out.println("   2 --> Test Java Concurrent Linked Queue;");
		System.out.println("   3 --> Test Java Linked Blocking Deque;");
		System.out.println("   4 --> Test Java Linked Blocking Queue;");
		System.out.println("   5 --> Test Java Linked Transfer Queue;");
		System.out.println("# ");

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		MyQueue<Integer> queue = null;
		String taskName = "";
		switch (n) {
		case 1:
			queue = new QueueWith2Stacks<Integer>();
			taskName = "QueueWith2StacksTask_AR";
			break;
		case 2:
			queue = new QueueWithJavaConcurrentLinkedQueue<Integer>();
			taskName = "QueueJavaConcurrentLinkedQueueTask_AR";
			break;
		case 3:
			queue = new QueueWithJavaLinkedBlockingDeque<Integer>();
			taskName = "QueueWithJavaLinkedBlockingDeque_AR";
			break;
		case 4:
			queue = new QueueWithJavaLinkedBlockingQueue<Integer>();
			taskName = "QueueWithJavaLinkedBlockingQueue_AR";
			break;
		case 5:
			queue = new QueueWithJavaLinkedTransferQueue<Integer>();
			taskName = "QueueWithJavaLinkedTransferQueue_AR";
			break;
		default:
			System.out.println("Wrong command.");
			break;
		}

		if (queue != null) {
			MyTask queueTask = new QueueTask(queue, taskName);
			queueTask.runTask();
			queueTask.checkCorrectness();
			queueTask.printResult();
		}
	}
}
