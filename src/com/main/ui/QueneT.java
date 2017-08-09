package com.lenovo.test;

public class QueneT {
	//�κε���Щ���ݽṹ������˳�����ɢ��
	//��β����ָ������һ���յ�,������Ч�����ÿռ䣬�ؼ�֮�������γɻ�
	
	static final int defaultSize =5;
	int front;  //head
	int rear;  //end
	int count; //ͳ�Ƶļ�����
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
			throw new Exception("��������");
		}
		
		queue[rear]=obj;
		rear++;
		if(rear >= maxSize) rear=0; //����ѭ�����еĵ㾦֮��
		count++;
	}
	
	
	public Object delete() throws Exception{
		if(isEmpty()) 
			throw new Exception("����Ϊ��");
		
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
