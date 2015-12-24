/**
 * Created by Coupang on 2015. 12. 24..
 */
public class Main {
	public static void main(String[] args){
		int[] arr = new int[5000];
		String[] str_arr = new String[1000];
		User[] user_arr = new User[1000];

		for (int i = 0 ; i < user_arr.length; i++){
			user_arr[i]=new User(arr.length+i,""+(arr.length-i));
		}
		for(int i = 0 ; i < str_arr.length ; i++){
			str_arr[i]=" "+(arr.length-i);
		}
		for(int i = 0 ; i < arr.length ; i++){
			arr[i] = arr.length-i;
		}

		System.out.println("");

		MyQuickSort qs = new MyQuickSort(arr);
		MyQuickSort qs2 = new MyQuickSort(str_arr);
		MyQuickSort q3 = new MyQuickSort(user_arr);
		qs.Sort();
		qs.print();

		qs2.Sort();
		qs2.print();

		q3.Sort();
		q3.print();
//		for(int i = 0 ; i < arr.length ; i++){
//			System.out.print(" "+arr[i]+" , ");
//		}

	}

}
