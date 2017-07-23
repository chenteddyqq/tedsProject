package com.main.ui;

public class QuickSort {
	
	public void myQuickSort(int[] nums, int begin, int end) {
		if (end-begin<=1 )
			return;
		int head = nums[begin];
		int idx = begin+1;
		for (int i = begin + 1; i < end; ) {
			if(nums[i]>=head) {
				i++;
				continue;
			}
			if (nums[i] < head && idx != i) {
				int tmp = nums[i];
				nums[i] = nums[idx];
				nums[idx] = tmp;
				idx++;
			}else{
				i++;
				idx++;
			}
		}
		int tmp = nums[idx-1];
		nums[idx-1] = head;
		nums[begin] = tmp;
		myQuickSort(nums, begin, idx);
		myQuickSort(nums, idx, end);
	}

	public void quickSort(int[] nums, int start, int end) {
		int pivot_Index=0;
		if(start < end){
			pivot_Index = partition(nums,start,end);
			quickSort(nums,start,pivot_Index);
			quickSort(nums, pivot_Index+1, end);
		}
	}

	int partition(int[] nums, int start, int end) {
		if(start == end) return start;
		int pivot_Index =start;
		int pivot = nums[start];
		int tmp;
		for(int i=start +1;i<end;i++){
			if(nums[i]<pivot){
				pivot_Index++;
				if(i!=pivot_Index){
					tmp = nums[pivot_Index];
					nums[pivot_Index]=nums[i];
					nums[i]=tmp;	
				}
			}
		}
		tmp=nums[start];
		nums[start]=nums[pivot_Index];
		nums[pivot_Index]=tmp;
		return pivot_Index;
	}

	public static void main(String[] args) {
		QuickSort q = new QuickSort();
		int[] nums = {19,-10,-2,40,5,40,-8,43,9,-5,-2,35,57,0,0,30,17,55,22,34,-4,42,57,-2,37,7};
		q.quickSort(nums, 0, nums.length);
		for (int i : nums) {
			System.out.print(i +"\t");
		}
		System.out.print("\n");
		int[] Mynums = {19,-10,-2,40,5,40,-8,43,9,-5,-2,35,57,0,0,30,17,55,22,34,-4,42,57,-2,37,7};
		q.myQuickSort(Mynums, 0, Mynums.length);
		for (int i : Mynums) {
			System.out.print(i +"\t");
		}
	}
}
