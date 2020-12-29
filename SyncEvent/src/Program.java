public class Program {
	public static void main(String[] args) throws InterruptedException {
//		Object s = new Object();
		class Sync {
			public int counter;
		}
		
		Sync s = new Sync();
		
		Thread t0 = new Thread(() -> {
			for (int i = 1; i <= 100; i++) {
				System.out.printf("%s : %d\n", Thread.currentThread().getName(), i);
				synchronized(s) {
					s.counter = i;
					s.notify();
//					s.notifyAll();
				}
				
//				if (i == 50) {
//					synchronized(s) {
//						s.notify();
//					}
//				}
			}
		});
		Thread t1 = new Thread(() -> {
			try {
				synchronized(s) {
					while (s.counter < 50) {
						s.wait(1);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int i = 1; i <= 100; i++) {
				System.out.printf("%s : %d\n", Thread.currentThread().getName(), i);
			}
		});
		
		t1.start();
//		Thread.sleep(500);
//		Thread.currentThread().join(); //deadlock
		t0.start();
	}
}