package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StopThread {

	private static volatile boolean stopRequested = false;
	private static volatile int nextSerialNumber = 0;

	private static int i = 0;

	/*
	 * private synchronized static boolean stopRequested() { return
	 * stopRequested; }
	 * 
	 * private synchronized static void requestStop() { stopRequested = true; }
	 */

	public static int generateSerialNumber() {
		return nextSerialNumber++;
	}

	public static void main(String[] args) throws InterruptedException {
		List<Integer> numbers = new ArrayList<Integer>();
		Thread newThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (!stopRequested) {
					numbers.add(generateSerialNumber());
				}
			}
		});
		newThread.start();
		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
		System.out.println(i);

		System.out.println(numbers.toString());
	}

}
