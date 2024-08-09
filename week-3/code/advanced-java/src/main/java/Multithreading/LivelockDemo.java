package Multithreading;

public class LivelockDemo {
	
	private static final Object lock1 = new Object();
	private static final Object lock2 = new Object();
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(() -> attemptLock(lock1, lock2));
		Thread t2 = new Thread(() -> attemptLock(lock1, lock2));
		
		t1.start();
		t2.start();

		
		
	}
	
	private static void attemptLock(Object firstLock, Object secondLock) {
		
		while(true) {
			synchronized (firstLock) {
				System.out.println(Thread.currentThread().getName() + "acquired" + firstLock);
				
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					
					Thread.currentThread().interrupt();
				}
				
				synchronized (secondLock) {
					
					System.out.println(Thread.currentThread().getName() + "acquired" + secondLock);
					System.out.println(Thread.currentThread().getName() +" completed the work");
					return;
					
					
					
				}
				
			}
		}
		
	}
	
	

}
