package com.lenovo.test;

public class Consumer implements Runnable {

	WindowQueue queue;
	
	public Consumer(WindowQueue queue){
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(queue.isAlive){
			
			queue.consumer();
		}

	}

}
