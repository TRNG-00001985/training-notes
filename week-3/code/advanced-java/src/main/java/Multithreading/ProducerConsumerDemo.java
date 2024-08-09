package Multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerDemo {
	
	private final Queue<Integer> queue = new LinkedList<Integer>();
	private final int MAX_CAPACITY = 4;
	
	
	public static void main(String[] args) {
		
		ProducerConsumerDemo p = new ProducerConsumerDemo();
		
		Thread producer = new Thread(p.new Producer());
		Thread consumer = new Thread(p.new Consumer());
		
		producer.start();
		consumer.start();
		
	}
	
	class Producer implements Runnable{

		@Override
		public void run() {
			
			int v = 0;
			
			while (true) {
				
				synchronized (queue) {
					
					while(queue.size() == MAX_CAPACITY) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					System.out.println("Produced" + v);
					queue.offer(v++);
					queue.notifyAll();
				}
			}
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class Consumer implements Runnable{

		@Override
		public void run() {
			
			while(true) {
				synchronized (queue) {
					while(queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					System.out.println(queue.poll());
					queue.notifyAll();
					
					
				}
			}
			
			
			// TODO Auto-generated method stub
			
		}
		
	}

}
