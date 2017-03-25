/**
 *  
 */
package algorithms.run.utils;

/**
 * @author Andrea Ranieri
 * @email and.ranieros@gmail.com
 */
public class PrintUtils {

	private char waitingChar;
	private int dimension;
	private int index;
	private int period;
	private int counter;

	public PrintUtils(char wc, int d, int p) {
		this.waitingChar = wc;
		this.dimension = d;
		this.period = p;
		this.index = 0;
		this.counter = 0;
	}

	public String running() {
		if (counter++ % period == 0) {
			StringBuffer sb = new StringBuffer();
			sb.append(this.waitingChar);
			if (this.index++ == this.dimension) {
				sb.append('\n');
				this.index = 0;
			}
			return sb.toString();
		} else
			return "";
	}
}
