package com.lenovo.test;

public class WindowQueue {

	private QueneT queue = new QueneT(1);
	
	int num = 0;
	
	int max = 100;
	
	boolean isAlive = true;
	
	public synchronized void producer(){
		if(queue.count < queue.maxSize && num<max){ //���������С�������Ϊ������ˣ��Ͳ����ټ���
			try {
				queue.append(++num);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("��"+num+"���û��������...");
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
			System.out.println("��"+temp+"���û��뿪...");
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
