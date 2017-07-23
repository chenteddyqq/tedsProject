package com.main.ui;

public class Permute {

	boolean[] flag = null;
	int[] nums = null;
	int[] result = null;

	public Permute(int[] nums) {
		flag = new boolean[nums.length];
		this.nums = nums;
		result = new int[nums.length];
	}

	public void iteratorPer(int index) {
		if (index >= nums.length) {
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i]);
			}
			System.out.println();
			return;
		}
		int lengthNum = nums.length;
		for (int i = 0; i < lengthNum; i++) {
			if (flag[i] == false) {
				result[index] = nums[i];
				flag[i] = true; //代表这个数用过
				iteratorPer(index + 1);
				flag[i] = false;//还原状态，回溯的关键就再于什么时候设定，然后什么时候设置回来。对比走迷宫的算法。
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1,2,3,4 };
		Permute p = new Permute(nums);
		p.iteratorPer(0);
	}
}
