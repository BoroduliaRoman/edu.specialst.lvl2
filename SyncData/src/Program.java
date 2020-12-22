class Sync2 {
	private volatile int counter = 0;
	
	public synchronized void increment() {
		counter++;
	}

	public int getCounter() {
		return counter;
	}
}

public class Program {
	public static void main(String[] args) throws InterruptedException {
//		class Sync {
//			public volatile int counter = 0;
//		}
		
//		final Sync s = new Sync();
//		final Object o = new Object();
		
		Sync2 s = new Sync2();
		
		Thread t0 = new Thread(() -> {
			for (int i = 1; i <= 10_000; i++) {
//				System.out.printf("%s : %d\n", Thread.currentThread().getName(), i);
//				counter++;
				/*synchronized(s)*/ {
//					s.counter = s.counter + 1;
					s.increment();
				}
			}
		});
		
		Thread t1 = new Thread(() -> {
			for (int i = 1; i <= 10_000; i++) {
//				System.out.printf("%s : %d\n", Thread.currentThread().getName(), i);
				/*synchronized (s)*/ {
//					s.counter++;
					s.increment();
				}
			}
		});
		
		t0.start();
		t1.start();
		
		t0.join();
		t1.join();
		
		System.out.println(s.getCounter());
	}
}