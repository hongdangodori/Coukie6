package com.coupang.samples.oop.sort;

import java.math.BigDecimal;

/**
 * Created by andew on 2015. 12. 23..
 */
public class SortMain {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Employee arr[] = new Employee[3];
		arr[0] = new Employee("andew", 1, new BigDecimal(1000));
		arr[1] = new Employee("andew", 2, new BigDecimal(1001));
		arr[2] = new Employee("andew", 3 ,new BigDecimal(1002));

		Integer arr2[] = { 5, 4, 3, 2, 1 };

		try {
			Qsort qsort = new Qsort();

			//Sort Employee
			qsort.sort(arr, new ISortCompare<Employee>() {
				@Override
				public boolean compare(Employee a, Employee b) {
					if (!a.wage.equals(b.wage))
						return a.wage.compareTo(b.wage) < 0;
					else if (a.id != b.id)
						return a.id > b.id;
					else
						return a.name.compareTo(b.name) < 0;
				}
			});
			qsort.print(arr);

			//Sort Integer
			qsort.sort(arr2, new ISortCompare<Integer>() {
				@Override
				public boolean compare(Integer a, Integer b) {
					return a < b;
				}
			});
			qsort.print(arr2);
		}
		catch (Exception e){
			e.printStackTrace();
		}

	}
}
