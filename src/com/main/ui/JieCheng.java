package com.main.ui;

public class JieCheng {
	
	//计算阶乘的算法
	public long jieCheng(int num) {
		if(num ==2) return 2;
		return num*jieCheng(num-1);
	}
	
	//折半查找
	public int halfSearch(int starting, int end, int target, int[] nums) {
		if(starting > end) return -1;
		int halfValue = nums[(starting + end)/2];
		if(target == halfValue) return (starting + end)/2;
		else if(target > halfValue ) {
			return halfSearch((starting + end)/2+1, end, target, nums);
		}
		return halfSearch(starting, (starting + end)/2-1, target, nums);
	}
	//波列那切的第n项
	public int fiboFunc(int index) {
		if(index == 1 || index == 2) return 1;
		return fiboFunc(index-1)+fiboFunc(index-2);
	}
	//前n项和
	public long sumFibo(int index) {
		long sum = 0;
		for(int i=1;i<=index;i++) {
			sum += fiboFunc(i);
		}
		return sum;
	}
	
	//辗转相除，最大公约数gcb
	public int gcb(int mini, int maxi) {
		if(mini<0 || maxi<0) return -1;
		/*if(maxi<mini) return gcb(maxi,mini);
		if(maxi % mini == 0) return mini;
		return gcb(maxi % mini, mini);*/
		int in_mini = Math.min(mini, maxi);
		int in_maxi = Math.max(mini, maxi);
		int result = in_maxi % in_mini;
		if(result == 0) return in_mini;
		while (result != 0) {
			int temp = in_mini;
			in_mini = in_maxi % in_mini;
			in_maxi = temp;
			result = in_maxi % in_mini;
		}
		return in_mini;
	}
}

class HannoiWhile {
	boolean flag = true; //这个是整个转非递归的精髓之处
	String a ="";
	String b="";
	String c="";
	int number = 0;
	public HannoiWhile() {}
	public HannoiWhile(String a,String b,String c,int n,boolean f) {
		this.a = a;
		this.b = b;
		this.c = c;
		number = n;
		flag = f;
	}
	
	void hanNoi(int n) {
		myStack<HannoiWhile> s = new myStack<HannoiWhile>();
		if(n<3) return;
		s.push(new HannoiWhile("b","a","c",n-1,true));
		s.push(new HannoiWhile("a","b","c",n,false));
		s.push(new HannoiWhile("a","c","b",n-1,true));
		while( s.size() != 0) {
			HannoiWhile temp = s.pop();
			if(temp.flag == false) printStack(temp);
			else {
				if(temp.number-1==1) {
					s.push(new HannoiWhile(temp.b,temp.a,temp.c,temp.number-1,false));
					s.push(new HannoiWhile(temp.a,temp.b,temp.c,temp.number,false));
					s.push(new HannoiWhile(temp.a,temp.c,temp.b,temp.number-1,false));
				}else {
					s.push(new HannoiWhile(temp.b,temp.a,temp.c,temp.number-1,true));
					s.push(new HannoiWhile(temp.a,temp.b,temp.c,temp.number,false));
					s.push(new HannoiWhile(temp.a,temp.c,temp.b,temp.number-1,true));
				}
			}
		}
	}

	void printStack(HannoiWhile i) {
			System.out.println("把"+i.number+"盘子从" + i.a + "移动到" + i.c);
	}
	
	public static void main(String[] args) {
		HannoiWhile hw = new HannoiWhile();
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
