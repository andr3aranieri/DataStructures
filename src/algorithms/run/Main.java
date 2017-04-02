/**
 *  
 */
package algorithms.run;

import java.util.Scanner;

import algorithms.algorithms.RunningMedian;
import algorithms.datastructures.QueueWith2Stacks;
import algorithms.datastructures.QueueWithJavaConcurrentLinkedQueue;
import algorithms.datastructures.QueueWithJavaLinkedBlockingDeque;
import algorithms.datastructures.QueueWithJavaLinkedBlockingQueue;
import algorithms.datastructures.QueueWithJavaLinkedTransferQueue;
import algorithms.datastructures.interfaces.MyQueue;
import algorithms.run.tasks.QueueTask;
import algorithms.run.tasks.RunningMedianTask;
import algorithms.run.tasks.interfaces.MyTask;

/**
 * @author Andrea Ranieri
 * @email and.ranieros@gmail.com
 */
public class Main {

	public static enum WhatToTest {
		QUEUE, RUNNINGMEDIAN
	};

	public static void main(String[] args) {
		System.out.println("Welcome. Commands:");
		System.out.println("   1 --> Test Queue with 2 stacks implementation;");
		System.out.println("   2 --> Test Java Concurrent Linked Queue;");
		System.out.println("   3 --> Test Java Linked Blocking Deque;");
		System.out.println("   4 --> Test Java Linked Blocking Queue;");
		System.out.println("   5 --> Test Java Linked Transfer Queue;");
		System.out.println("   6 --> Test Runnig median algorithm with 2 priority queues;");
		System.out.println("# ");

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		MyQueue<Integer> queue = null;
		String taskName = "";
		WhatToTest wtt = null;
		switch (n) {
		case 1:
			queue = new QueueWith2Stacks<Integer>();
			taskName = "QueueWith2StacksTask_AR";
			wtt = WhatToTest.QUEUE;
			break;
		case 2:
			queue = new QueueWithJavaConcurrentLinkedQueue<Integer>();
			taskName = "QueueJavaConcurrentLinkedQueueTask_AR";
			wtt = WhatToTest.QUEUE;
			break;
		case 3:
			queue = new QueueWithJavaLinkedBlockingDeque<Integer>();
			taskName = "QueueWithJavaLinkedBlockingDeque_AR";
			wtt = WhatToTest.QUEUE;
			break;
		case 4:
			queue = new QueueWithJavaLinkedBlockingQueue<Integer>();
			taskName = "QueueWithJavaLinkedBlockingQueue_AR";
			wtt = WhatToTest.QUEUE;
			break;
		case 5:
			queue = new QueueWithJavaLinkedTransferQueue<Integer>();
			taskName = "QueueWithJavaLinkedTransferQueue_AR";
			wtt = WhatToTest.QUEUE;
			break;
		case 6:
			taskName = "RunningMedianWith2PriorityQueues_AR";
			wtt = WhatToTest.RUNNINGMEDIAN;
			break;
		default:
			System.out.println("Wrong command.");
			break;
		}

		switch (wtt) {
		case QUEUE:
			MyTask queueTask = new QueueTask(queue, taskName);
			queueTask.runTask();
			queueTask.checkCorrectness();
			queueTask.printResult();
			break;
		case RUNNINGMEDIAN:
			RunningMedianTask rmt = new RunningMedianTask(taskName, new RunningMedian());
			rmt.runTask();
			rmt.checkCorrectness();
			rmt.printResult();
			break;
		}
	}
}
