import java.util.ArrayList;

/**
 * Created by Ssun on 2015. 12. 24..
 */
public interface Qsort<T> {
	void doSort(ArrayList<T> arr) throws Exception;
	boolean validCheck(ArrayList<T> arr);
}
