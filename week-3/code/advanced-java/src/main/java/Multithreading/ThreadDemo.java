package Multithreading;

public class ThreadDemo extends Thread{
	
	public void run() {
		System.out.println("Thread is running " + Thread.currentThread().getName());
	}
	
	
	
	public static void main(String[] args) {
		
//		ThreadDemo t1 = new ThreadDemo();
//		ThreadDemo t2 = new ThreadDemo();
//		
//		t1.start();
//		t2.start();
//		
		RunnableDemo r = new RunnableDemo();
		
		Thread t1 = new Thread(r);
		
		System.out.println(t1.getState());

		t1.start();
		
		System.out.println(t1.getState());
		
		//System.out.println(t1.getState());
		
		for (Thread.State state : Thread.State.values()) {
			System.out.println(state);
			
		}

		
		
		
		
	}

}

class RunnableDemo implements Runnable{
	
	@Override
	public void run() {
		
		
		try {
			System.out.println("Thread is running " + Thread.currentThread().getName());
			Thread.sleep(1000);
			System.out.println("Thread completed execution " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
}
