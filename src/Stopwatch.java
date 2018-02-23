
public class Stopwatch {
	
	private long startTime;
	private long stopTime;
	private boolean running;
	private static final double NANOSECOND = 1.0E-9;
	
	public Stopwatch() {
		this.running = false;
	}
	
	public void start() {
		if (running) return;
		running = true;
		startTime = System.nanoTime();
	}
	
	public void stop() {
		if (!running) return;
		stopTime = System.nanoTime();
		running = false;
	}
	
	/** Check if the stopwatch is running. */
	public boolean isRunning() {
		return running;
	}
	
	/** Get the elapsed time in seconds. */
	public double getElapsed() {
		if (running) return (System.nanoTime() - startTime)* NANOSECOND;
		
		else return (stopTime - startTime)* NANOSECOND;
	}

}
