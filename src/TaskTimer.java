/**
 * This method is created to start the stopwatch of each runnable object.
 * @author Dechabhol Kotheeranurak
 *
 */
public class TaskTimer {
	
	private Stopwatch s;
	private Runnable task;
	
	public TaskTimer(Runnable task) {
		this.task = task;
		s = new Stopwatch();
		s.start();
		task.run();
		s.stop();
	}
	
	public double getTime() {		
		return s.getElapsed();
	}
	
	public int getChar() {
		return Integer.parseInt(task.toString());
	}
	
	public String toString() {
		return String.format("Read %d characters %f secs.", this.getChar(), this.getTime());
	}

}
