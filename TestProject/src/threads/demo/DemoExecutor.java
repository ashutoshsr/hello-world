package threads.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class DemoExecutor {

	public static void main(String args[]) {
		int threadCounter = 0;
		BlockingQueue<Runnable> blocker = new ArrayBlockingQueue<>(50);

		CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(10, 20, 5000, TimeUnit.MILLISECONDS, blocker);

		executor.prestartAllCoreThreads();
		while (true) {
			threadCounter++;
			System.out.println("thread counter " + threadCounter);
			executor.execute(new DemoThread(threadCounter + ""));
			if (threadCounter == 100) {
				break;
			}
		}
	}

}
