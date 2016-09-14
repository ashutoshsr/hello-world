package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorCompServ {
	public static void main(String args[]) {

		List<Callable> callsList = new ArrayList<>();
		Callable<Integer> calls = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				System.out.println("execting " + this);
				return (int) Math.random();
			}
		};
		ExecutorService executor = new ThreadPoolExecutor(10, 20, 5000, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(10), new RejectedExecutionHandler() {

					@Override
					public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
						System.out.println("Thread name");
					}
				});
		for (int i = 0; i < 10; i++) {
			final int threadNum = i;
			System.out.println("execting threadNum : " + threadNum);
			try {
				callsList.add(calls);
				executor.submit(new Callable<Integer>() {
					@Override
					public Integer call() throws Exception {
						System.out.println("execting " + this);
						return 4;
					}
				});
			} catch (Exception e) {
				throw new AssertionError(e.getCause());
			} finally {
				executor.shutdown();
			}
		}

		final ExecutorService pool = Executors.newFixedThreadPool(5);
		ExecutorCompletionService<Integer> completionService = new ExecutorCompletionService<>(pool);
		for (int i = 0; i < 10; i++) {
			completionService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					System.out.println("Run this one please " + this);
					return 4;
				}
			});
		}
		String values = null;
		for (int i = 0; i < 10; i++) {
			try {
				Future<Integer> result = completionService.take();
				System.out.println(result.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (values != null) {
			System.out.println(values);
		}
	}

}