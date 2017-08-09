package com.lenovo.test;

public class Producer implements Runnable {

	
	WindowQueue queue;
	
	public Producer(WindowQueue queue){
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(queue.isAlive){	
			queue.producer();
		}

	}
	
}
