package com.main.ui;

public class HannoiFinalWhile {
	boolean flag = true; //这个是整个转非递归的精髓之处
	String a ="";
	String b="";
	String c="";
	int number = 0;
	public HannoiFinalWhile() {}
	public HannoiFinalWhile(String a,String b,String c,int n,boolean f) {
		this.a = a;
		this.b = b;
		this.c = c;
		number = n;
		flag = f;
	}
	
	void hanNoi(int n) {
		myStack<HannoiFinalWhile> s = new myStack<HannoiFinalWhile>();
		if(n<3) return;
		s.push(new HannoiFinalWhile("b","a","c",n-1,true));
		s.push(new HannoiFinalWhile("a","b","c",n,false));
		s.push(new HannoiFinalWhile("a","c","b",n-1,true));
		while( s.size() != 0) {
			HannoiFinalWhile temp = s.pop();
			if(temp.flag == false) printStack(temp);
			else {
				if(temp.number-1==1) {
					s.push(new HannoiFinalWhile(temp.b,temp.a,temp.c,temp.number-1,false));
					s.push(new HannoiFinalWhile(temp.a,temp.b,temp.c,temp.number,false));
					s.push(new HannoiFinalWhile(temp.a,temp.c,temp.b,temp.number-1,false));
				}else {
					s.push(new HannoiFinalWhile(temp.b,temp.a,temp.c,temp.number-1,true));
					s.push(new HannoiFinalWhile(temp.a,temp.b,temp.c,temp.number,false));
					s.push(new HannoiFinalWhile(temp.a,temp.c,temp.b,temp.number-1,true));
				}
			}
		}
	}

	void printStack(HannoiFinalWhile i) {
			System.out.println("把"+i.number+"盘子从" + i.a + "移动到" + i.c);
	}
	
	public static void main(String[] args) {
		HannoiFinalWhile hw = new HannoiFinalWhile();
		hw.hanNoi(24);
	}
}

//自定义的stack类，得用链表
class myStack<T> {

	private innerItem<T> top=null;
	private long length=0;
	
	public void push(T t) {
		innerItem<T> temp = new innerItem<T>(t);
		if (top != null) {
			temp.nextItem = top;
		}
		top = temp ;
		length++;
	}
	
	public T pop() {
		if(top == null) return null;
		innerItem<T> temp = top;
		top = top.nextItem;
		length--;
		return temp.currentItem;
	}
	
	public long size() {
		return length;
	}
}
//作用相当与linkedItem
class innerItem<T>{
	T currentItem = null;
	innerItem<T> nextItem = null;
	public innerItem(T t){
		currentItem = t;
	}
}
