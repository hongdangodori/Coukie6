/**
 * Created by Coupang on 2015. 12. 24..
 */
public class LastMyQuickSort implements QuickSortInter{
	private Comparable[] str_arr;

	public LastMyQuickSort(Comparable[] arr){
		this.str_arr = arr;
	}

	public LastMyQuickSort(int[] arr){
		this.str_arr = new Integer[arr.length];
		for(int n = 0 ; n < arr.length; n++ ){
			str_arr[n] = new Integer(arr[n]);
		}
	}
	private int partition(int left, int right)
	{
		int i = left, j = right;

		Comparable pivot = str_arr[left];

		while (i <= j) {
			while (str_arr[i].compareTo(pivot) < 0)
				i++;
			while (str_arr[j].compareTo(pivot) > 0)
				j--;
			if (i <= j) {
				swap(i,j);
				i++;
				j--;
			}
		};

		return i;
	}
	@Override
	public void swap(int i,int j){
		Comparable tmp = str_arr[i];
		str_arr[i] = str_arr[j];
		str_arr[j] = tmp;
	}

	@Override public void Shuffle() {
		int i = (int) System.currentTimeMillis();
		int r=1, k = i % (str_arr.length);
		int t;
		if(str_arr.length > 0) {
			for (int j = 0; j < str_arr.length; j++) {
				k += 1;
				t = j + r * (k % str_arr.length);

				if (t < 0) {
					t = t + (str_arr.length - 1);
				} else if (t >= str_arr.length) {
					t -= str_arr.length;
				}

				swap(i,j);

				r *= (-1);
			}
		}
	}

	@Override
	public void quickSort(){
		quickSort(0, str_arr.length-1);
	}

	@Override public void printSort() {
		for(int k=0;k<str_arr.length;k++) {
			System.out.print("[" +str_arr[k].toString()+"]");
		}
		System.out.println("");
	}

	private void quickSort(int left, int right) {
		int index = partition(left, right);

		if (left < index - 1)
			quickSort(left, index - 1);
		if (index < right)
			quickSort(index, right);

	}
}
