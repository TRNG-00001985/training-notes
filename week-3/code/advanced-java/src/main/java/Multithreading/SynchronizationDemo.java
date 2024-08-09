package Multithreading;

public class SynchronizationDemo {
	
	private int counter = 0;
	
	public synchronized void increment() {
		counter++;
	}
	
	public synchronized int getCounter() {
		return counter;
	}
	
	public static void main(String[] args) {
		
		SynchronizationDemo s = new SynchronizationDemo();
		
		Thread t1 = new Thread (() ->{
			for(int i=0;i<100;i++) {
				s.increment();
			}
			
		});
		
		Thread t2 = new Thread ( () ->{
			for(int i=0;i<100;i++) {
				
				s.increment();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
			
		}
		catch(InterruptedException e) {
			
			Thread.currentThread().interrupt();
		}
		
		System.out.println("Final Count " + s.getCounter() );
		
	}

}
