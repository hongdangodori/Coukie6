import java.math.BigDecimal;

/**
 * Created by Ssun on 2015. 12. 24..
 */
public class Employee implements Comparable<Employee> {
	String name;
	BigDecimal monthlyPay;

	Employee(String name, BigDecimal monthlyPay) {
		this.name = name;
		this.monthlyPay = monthlyPay;
	}

	public String print() {
		return "[name : " + name + " montlyPay : " + monthlyPay;
	}

	@Override public int compareTo(Employee o) {
		if (this.monthlyPay != o.monthlyPay)
			return (this.monthlyPay.subtract(o.monthlyPay)).intValue();
		else return this.name.compareTo(o.name);
	}
}