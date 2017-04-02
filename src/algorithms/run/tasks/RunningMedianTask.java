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

import algorithms.algorithms.RunningMedian;
import algorithms.run.results.Result;
import algorithms.run.results.interfaces.MyResult;
import algorithms.run.tasks.interfaces.MyTask;

/**
 * @author Andrea Ranieri
 * @email and.ranieros@gmail.com
 */
public class RunningMedianTask implements MyTask {

	private MyResult result;
	private String name;
	private RunningMedian algorithm;
	private List<String> myResults;

	public RunningMedianTask(String n, RunningMedian rm) {
		this.name = n;
		this.result = new Result(this.name);
		this.algorithm = rm;
		this.myResults = new ArrayList<String>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see algorithms.run.tasks.interfaces.MyTask#runTask()
	 */
	@Override
	public void runTask() {
		Scanner scanInput = null;
		try {
			scanInput = new Scanner(new FileInputStream(new File("inputdata/RunningMedian/Input1")));
			result.start();
			int n = scanInput.nextInt();
			int[] a = new int[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = scanInput.nextInt();

				this.algorithm.addNewValue(a[a_i]);
				String s = this.algorithm.getRunningMedian();
				this.myResults.add(s);
				System.out.println(s);
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
	 * @see algorithms.run.tasks.interfaces.MyTask#checkCorrectness()
	 */
	@Override
	public void checkCorrectness() {
		Scanner scanOutput = null;
		try {
			scanOutput = new Scanner(new FileInputStream(new File("inputdata/RunningMedian/Output1")));
			int i = 0;
			String read = "";
			String real = "";
			while (scanOutput.hasNext()) {
				real = this.myResults.get(i++);
				read = scanOutput.next();
				if (!real.equals(read)) {
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
