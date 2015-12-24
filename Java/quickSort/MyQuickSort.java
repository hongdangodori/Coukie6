/**
 * Created by Coupang on 2015. 12. 24..
 */
public class MyQuickSort {
	private QuickSortInter qs;

	public MyQuickSort(int[] arr){
		qs = new LastMyQuickSort(arr);
	}
	public MyQuickSort(Comparable[] arr){
		qs = new LastMyQuickSort(arr);
	}

	public void Sort(){
		qs.quickSort();
	}
	public void print(){
		qs.printSort();
	}

}
