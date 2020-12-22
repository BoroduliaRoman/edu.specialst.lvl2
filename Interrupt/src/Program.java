public class Program {
	public static void main(String[] args) {
		Thread t0 = new Thread(() -> {
			for (int i = 1; i <= 100; i++) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					System.out.printf("%s : interrupted from sleep", Thread.currentThread().getName());
					return;
				}
				
				if (Thread.interrupted()) {
					System.out.printf("%s : interrupted", Thread.currentThread().getName());
					return;
				} else {
					System.out.printf("%s : %d\n", Thread.currentThread().getName(), i);		
				}
			}
		});
		
		t0.start();
		t0.interrupt();
		
		System.out.println("main");
	}
}