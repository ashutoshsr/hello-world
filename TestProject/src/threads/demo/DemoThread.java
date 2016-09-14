package threads.demo;

public class DemoThread implements Runnable{
	private String name;
	
	public DemoThread(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name);
	}

}
