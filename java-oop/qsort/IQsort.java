package com.coupang.samples.oop.sort;


/**
 * Created by andew on 2015. 12. 24..
 */
public interface IQsort<T> {
	void sort(T arr[]) throws SortException;
	void sort(T arr[], ISortCompare<T> sortCompare) throws SortException;
	void setCompare(ISortCompare<T> sortCompare);
	void print(T arr[]);
}
