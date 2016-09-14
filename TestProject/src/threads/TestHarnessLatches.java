package threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestHarnessLatches {

	public static void main(String args[]) throws InterruptedException {
		ExecutorService executor = new ThreadPoolExecutor(1, 2, 5, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(10));
		System.out.println(TestHarnessLatches.time(Executors.newSingleThreadExecutor(), 2, new Runnable() {

			@Override
			public void run() {
				System.out.println("start Working");
			}
		}));
	}

	public static long time(Executor exe, int concurrency, final Runnable action) throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(concurrency);

		for (int i = 0; i < concurrency; i++) {
			exe.execute(new Runnable() {

				@Override
				public void run() {
					try {
						startGate.await();
						System.out.println("4");
						action.run();
						System.out.println("5");
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					} finally {
						endGate.countDown();
						System.out.println("6");
					}
				}
			});
		}

		System.out.println("1");
		long startTime = System.nanoTime();
		startGate.countDown();
		System.out.println("2");
		endGate.await();
		System.out.println("3");
		return System.nanoTime() - startTime;
	}
}
