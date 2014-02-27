package library;

public class StopWatch {

	private static StopWatch instance;
	private long start;

	public static StopWatch getInstance() {
		if (instance == null) {
			instance = new StopWatch();
		}
		return instance;
	}

	private StopWatch() {
	}

	public void start() {
		start = System.currentTimeMillis();
	}

	public void stop() {
		long stop = System.currentTimeMillis();
		long result = stop - start;
		System.out.println(result);
	}
}
