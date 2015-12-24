import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ssun on 2015. 12. 23..
 */
public class Tester {
	public static void main(String args[]) {
		int size;
		int max;

		QsortImplementation qc = new QsortImplementation();

		ArrayList<Integer> intArr = new ArrayList<Integer>();
		Random r = new Random();

		System.out.println("Int qsort Test ----------------------------------------------------");
		size = 1000000;
		max = 5000000;
		for (int k = 0; k < 5; k++) {
			intArr.clear();
			for (int i = 0; i < size; ++i) {
				intArr.add(r.nextInt(max));
			}
			//System.out.println(intArr);

			try {
				long sttime = System.nanoTime();
				qc.doSort(intArr);
				long edtime = System.nanoTime();


				//System.out.println(intArr);
				System.out.println("case "+k+": valid : " +qc.validCheck(intArr)+" sort time = " + (edtime - sttime) / 1000000 + "ms");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Test End ----------------------------------------------------------");
		System.out.println("Int qsort Test ----------------------------------------------------");

		ArrayList<String> strArr = new ArrayList<String>();
		strArr.add("sort test");
		strArr.add("sort teSt");
		strArr.add("Sort test");
		strArr.add("sOrt test");
		strArr.add("sort Test");

		for (int k = 0; k < 1; k++) {
			//System.out.println(strArr);

			try {
				long sttime = System.nanoTime();
				qc.doSort(strArr);
				long edtime = System.nanoTime();

				System.out.println(strArr);
				System.out.println("case "+k+": valid : " +qc.validCheck(strArr)+" sort time = " + (edtime - sttime) / 1000000 + "ms");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("Test End ----------------------------------------------------------");
		System.out.println("Int entity Test ----------------------------------------------------");

		ArrayList<Employee> empArr = new ArrayList<Employee>();
		empArr.add(new Employee("ksm", new BigDecimal(1000000)));
		empArr.add(new Employee("ksz", new BigDecimal(2000000)));
		empArr.add(new Employee("khm", new BigDecimal(2000000)));
		empArr.add(new Employee("kyu", new BigDecimal(1000000)));

		for (int k = 0; k < 1; k++) {
			//System.out.println(strArr);

			try {
				long sttime = System.nanoTime();
				qc.doSort(empArr);
				long edtime = System.nanoTime();

				for(int i=0;i<empArr.size();++i){
					System.out.println(empArr.get(i).print());
				}
				System.out.println("case "+k+": valid : " +qc.validCheck(empArr)+" sort time = " + (edtime - sttime) / 1000000 + "ms");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("Test End ----------------------------------------------------------");
	}
}
