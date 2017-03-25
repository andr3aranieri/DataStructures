/**
 *  
 */
package algorithms.run.results.interfaces;

/**
 *  @author Andrea Ranieri
 *  @email  and.ranieros@gmail.com	
 */
public interface MyResult {
	public void setSuccess(boolean success);
	public void start();
	public void end();
	public long getExecutionTimeMillis();
	public float getExecutionTimeSecs();
}
