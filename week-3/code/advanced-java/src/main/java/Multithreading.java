
public class Multithreading extends Thread{
	
	public void run() {
		try {
            System.out.println("Thread is running...");
            // Simulate some work with sleep
            Thread.sleep(500);
            System.out.println("Thread completed execution.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
//		Multithreading m = new Multithreading();
//		System.out.println(m.getState());
//		m.start();
//		System.out.println(m.getState());
		
		demo d = new demo();
		Thread t = new Thread(d);
		System.out.println(t.getState());

		t.start();
//		System.out.println(t.getState());
//		t.sleep(400);
//		System.out.println(t.getState());
		
		while (t.getState() != Thread.State.TERMINATED) {
            System.out.println("Current State: " + t.getState());
            try {
                // Sleep for a short time to allow the state to change
                Thread.sleep(100);
            	
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		
//		for(Thread.State state: Thread.State.values()) {
//			System.out.println(state);
//		}
//		
		



		
		
	}

}

class demo implements Runnable{

	@Override
	public void run() {
		try {
            System.out.println("Thread is running...");
            // Simulate some work with sleep
            Thread.sleep(500);
            System.out.println("Thread completed execution.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
	}
	
	
}
