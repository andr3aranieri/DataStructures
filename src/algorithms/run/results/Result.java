/**
 *  
 */
package algorithms.run.results;

import java.util.Date;

import algorithms.run.results.interfaces.MyResult;

/**
 * @author Andrea Ranieri
 * @email and.ranieros@gmail.com
 */
public class Result implements MyResult {
	private String name;
	private Date start;
	private Date end;
	private boolean success;

	public Result(String name) {
		this.name = name;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void start() {
		this.start = new Date();
	}

	public void end() {
		this.end = new Date();
	}

	public long getExecutionTimeMillis() {
		return this.end.getTime() - this.start.getTime();
	}

	public float getExecutionTimeSecs() {
		return (this.end.getTime() - this.start.getTime()) / 1000;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("***********************************");
		sb.append('\n');
		sb.append("***********************************");
		sb.append('\n');
		sb.append("***********************************");
		sb.append('\n');
		sb.append("Results of the task: ");
		sb.append(this.name);
		sb.append('\n');
		sb.append("Success: ");
		sb.append(this.success ? "YES" : "NO");
		sb.append('\n');
		sb.append("Duration (seconds): ");
		sb.append(this.getExecutionTimeSecs());
		sb.append('\n');
		sb.append("Duration (milliseconds): ");
		sb.append(this.getExecutionTimeMillis());
		sb.append('\n');
		sb.append("***********************************");
		sb.append('\n');
		sb.append("***********************************");
		sb.append('\n');
		sb.append("***********************************");
		sb.append('\n');
		return sb.toString();
	}

}
