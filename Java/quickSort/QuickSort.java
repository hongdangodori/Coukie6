/**
 * Created by Coupang on 2015. 12. 23..
 */


public class QuickSort {


	public int[] Shuffle(int[] arr){

		int i = (int) System.currentTimeMillis();

		int r=1, k = i % (arr.length);
		int t;
		int temp=0;

		for(int j = 0 ; j < arr.length ; j++){
			k += 1;
			t = j + r * ( k % arr.length );

			if(t<0){
				t = t + ( arr.length - 1 );
			}else if(t >= arr.length){
				t -= arr.length;
			}

			temp = arr[j];
			arr[j] = arr[t];
			arr[t] = temp;

			r *= (-1);
		}
		return arr;
	}

	int partition(int arr[], int left, int right)
	{
		int i = left, j = right;
		int tmp;
		int pivot = arr[left];

		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		};

		return i;
	}

	void quickSort(int arr[], int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1)
			quickSort(arr, left, index - 1);
		if (index < right)
			quickSort(arr, index, right);
	}

	public static void main(String[] args){
		int[] arr=new int[7000];
		for(int i = 0 ; i < arr.length ; i++){
			arr[i] = arr.length-i;
		}
		QuickSort qs= new QuickSort();


		long startTime = System.currentTimeMillis();


		arr = qs.Shuffle(arr);

		for(int k=0;k<arr.length;k++) {
			System.out.print("[" +arr[k]+"]");
		}
		System.out.println("");

		qs.quickSort(arr, 0, arr.length - 1);

		long endTime = System.currentTimeMillis();
		// 시간 출력
		System.out.println("##  소요시간(초.0f) : " + ( endTime - startTime )/1000.0f +"초");

		for(int k=0;k<arr.length;k++) {
			System.out.print("[" +arr[k]+"]");
		}
		System.out.println("");



	}

}
