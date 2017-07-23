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

