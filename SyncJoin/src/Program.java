public class Program {
	public static void main(String[] args) throws InterruptedException {
		Thread t0 = new Thread(() -> {
			for (int i = 1; i <= 100; i++) {
				System.out.printf("%s : %d\n", Thread.currentThread().getName(), i);
			}
		});
		Thread t1 = new Thread(() -> {
			try {
				t0.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int i = 1; i <= 100; i++) {
				System.out.printf("%s : %d\n", Thread.currentThread().getName(), i);
			}
		});
		
//		t1.start();
//		Thread.sleep(100);
//		t0.start();
		
		t0.start();
		t1.start();
		
		t0.join();
		t1.join();
		
//		Thread.sleep(25);
		
		System.out.println(Thread.currentThread().getName()); //main
	}
}