package com.lenovo.test;

public class QueneT {
	//任何的这些数据结构，都有顺序和离散的
	//队尾总是指向最后的一个空的,怎样有效的利用空间，关键之处就是形成环
	
	static final int defaultSize =5;
	int front;  //head
	int rear;  //end
	int count; //统计的计数器
	int maxSize;
	Object[] queue;
	
	private void init(int size){
		maxSize = size;
		front = rear = 0;
		count = 0;
		queue = new Object[size];
	}
	
	public QueneT(){
		init(defaultSize);
	}
	
	public QueneT(int size){
		init(size);
	}
	
	public void append(Object obj) throws Exception{
		if(count>0 && rear == front){
			throw new Exception("队列已满");
		}
		
		queue[rear]=obj;
		rear++;
		if(rear >= maxSize) rear=0; //这是循环队列的点睛之处
		count++;
	}
	
	
	public Object delete() throws Exception{
		if(isEmpty()) 
			throw new Exception("队列为空");
		
		Object temp = queue[front];
		front++;
		if(front >= maxSize) front=0;
		count--;
		return temp;
	}
	
	
	public Object getFront(){
		if(!isEmpty()) 
			return queue[front];
		
		return null;
	}
	
	public boolean isEmpty(){
		
		return count==0;
	}

}
