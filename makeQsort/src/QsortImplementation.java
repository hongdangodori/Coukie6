import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ssun on 2015. 12. 23..
 */
public class QsortImplementation<T extends Comparable<T>> implements Qsort<T> {
	Random r = new Random();
	Comp c = new Comp();

	// 외부로부터 호출되는 메소드. 타입 검사 후 소팅
	public void doSort(ArrayList<T> arr) throws Exception {
		if (arr.size() < 0)
			throw new IndexOutOfBoundsException();
		if (!elementTypeCheck(arr.get(0))) {
			throw new InvalidClassException(arr.get(0).getClass() + " is not supported");
		}
		for (int i = 1; i < arr.size(); ++i) {
			if (arr.get(i).getClass() != arr.get(0).getClass())
				throw new InvalidClassException("this qsort doesn't support multi type sorting");
		}

		sort(arr, 0, arr.size() - 1);
	}

	// sorting 결과 확인용 함수
	public boolean validCheck(ArrayList<T> arr) {
		boolean ret = true;
		for (int i = 0; i < arr.size() - 1; ++i) {
			if (arr.get(i).compareTo(arr.get(i + 1)) > 0) {
				//System.out.println("not valid in arr " + i + "(" + arr.get(i) + " " + arr.get(i + 1) + ")");
				ret = false;
			}
		}

		return ret;
	}

	// 타입체
	private boolean elementTypeCheck(T a) {
		boolean ret = true;

		if (a.getClass() == Integer.class)
			;
		else if (a.getClass() == String.class)
			;
		else if (a.getClass() == Employee.class)
			;
		else {
			ret = false;
		}

		return ret;
	}

	// 퀵소트 본문
	private void sort(ArrayList<T> arr, int first, int last) {
		int left, right;
		T pivot;

		shuffle(arr, first, last);

		pivot = arr.get(first);

		left = first + 1;
		right = last;
		while (left < right) {
			while (left < last && comp(pivot, arr.get(left))) {
				++left;
			}
			while (right > first && comp(arr.get(right), pivot)) {
				--right;
			}

			if (left < right) {
				swap(arr, left, right);
			}
		}

		//System.out.println(arr);
		if (comp(pivot, arr.get(right)))
			swap(arr, first, right);

		if (first < right)
			sort(arr, first, right - 1);
		if (last > right)
			sort(arr, right + 1, last);
	}

	// 비교함수
	private boolean comp(T a, T b) {
		return ((Comparable) a).compareTo(b) >= 0;
	}

	// 셔플
	private void shuffle(ArrayList<T> arr, int first, int last) {
		int randIndex;

		randIndex = r.nextInt(last - first + 1);
		swap(arr, first + randIndex, first);
	}

	// exchange
	private void swap(ArrayList<T> arr, int i, int j) {
		T temp;
		temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
}