package com.coupang.samples.oop.sort;

import java.util.Random;

/**
 * Created by andew on 2015. 12. 23..
 */
public class Qsort<T> implements IQsort<T> {
	private Random rand;
	private int i, last;
	private T[] arr;
	private ISortCompare<T> sortCompare;

	public Qsort(){
		rand = new Random();
	}

	private void swap(int a , int b){
		T tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	private void shuffle(int start, int end){
		for(int i = 0; i <= (end - start + 1)/2; i++){
			swap(start + i, end - i);
		}
	}

	private void qsortByShuffle(int start, int end){
		//Return Condition
		if(end <= start) return;

		//Shuffling
		shuffle(start, end);

		//Randomized Pivot
		swap(start, rand.nextInt(end - start) + start);

		//Partitioning
		last = start;
		for(i = start; i <= end; i++)
			if(sortCompare.compare(arr[i], arr[start]))
				swap(++last, i);

		swap(start, last);

		qsortByShuffle(start, last - 1);
		qsortByShuffle(last + 1, end);
	}

	@Override
	public void sort(T arr[]) throws SortException {
		if(arr == null || arr.length < 0){
			throw new SortException("size under 0 or null");
		}
		this.arr = arr;
		qsortByShuffle(0, this.arr.length - 1);
	}

	@Override
	public void sort(T arr[], ISortCompare<T> sortCompare) throws SortException {
		if(arr == null || arr.length < 0){
			throw new SortException("size under 0 or null");
		}
		this.arr = arr;
		this.sortCompare = sortCompare;
		qsortByShuffle(0, this.arr.length - 1);
	}

	@Override
	public void print(T arr[]){
		for (T one : arr){
			System.out.println(one.toString());
		}
	}

	@Override
	public void setCompare(ISortCompare<T> sortCompare){
		this.sortCompare = sortCompare;
	}
}

