package com.lenovo.test;

public class WindowQueue {

	private QueneT queue = new QueneT(1);
	
	int num = 0;
	
	int max = 100;
	
	boolean isAlive = true;
	
	public synchronized void producer(){
		if(queue.count < queue.maxSize && num<max){ //这里必须是小于最大，因为如果满了，就不能再加了
			try {
				queue.append(++num);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("第"+num+"个用户进入队列...");
			this.notifyAll();
		}else{
			
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void consumer(){
		if(!queue.isEmpty()){
			int temp = 0;
			try {
				temp = Integer.parseInt(queue.delete().toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("第"+temp+"个用户离开...");
			if(num >=max) this.isAlive = false; 
			this.notifyAll();
		}else{
			
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
