/**
 *  
 */
package algorithms.algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {
	private PriorityQueue<Integer> lower = new PriorityQueue<Integer>(10 ^ 5, new Comparator<Integer>() {
		@Override
		public int compare(Integer i1, Integer i2) {
			return i2.compareTo(i1);
		}
	});
	private PriorityQueue<Integer> higher = new PriorityQueue<Integer>(10 ^ 5, new Comparator<Integer>() {
		@Override
		public int compare(Integer i1, Integer i2) {
			return i1.compareTo(i2);
		}
	});

	private void reverseMedianValues() {
		Integer tmp = this.higher.poll();
		this.higher.add(this.lower.poll());
		this.lower.add(tmp);
	}

	public void addNewValue(int value) {
		if (this.lower.size() == 0) {
			this.lower.add(value);
			if (this.higher.size() > 0) {
				if (this.higher.peek() < this.lower.peek()) {
					this.reverseMedianValues();
				}
			}
		} else if (this.higher.size() == 0) {
			this.higher.add(value);
			if (this.lower.size() > 0) {
				if (this.higher.peek() < this.lower.peek()) {
					this.reverseMedianValues();
				}
			}
		} else if (this.higher.size() < this.lower.size() + 1) {
			// higher needs to grow;
			if (value >= this.lower.peek()) {
				this.higher.add(value);
			} else {
				this.higher.add(this.lower.poll());
				this.lower.add(value);
			}
		} else {
			// lower needs to grow;
			if (value <= this.higher.peek()) {
				this.lower.add(value);
			} else {
				this.lower.add(this.higher.poll());
				this.higher.add(value);
			}
		}
	}

	public String getRunningMedian() {
		switch (this.higher.size() - this.lower.size()) {
		case 0:
			return String.format("%.1f", (float) (this.higher.peek() + this.lower.peek()) / 2);
		case 1:
			return String.format("%.1f", (float) this.higher.peek());
		case -1:
			return String.format("%.1f", (float) this.lower.peek());
		default:
			return "ERROR";
		}
	}
}
