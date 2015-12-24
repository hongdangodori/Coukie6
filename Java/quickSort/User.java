/**
 * Created by Coupang on 2015. 12. 24..
 */
public class User implements Comparable{
	private int salary;
	private String name;

	public User(int salary, String name) {

		this.salary = salary;
		this.name = name;
	}

	public User(String name) {
		this.name = name;
	}

	public User(int salary) {
		this.salary = salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getSalary() {

		return salary;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Object o) {
		User u = (User) o;
		int diff = this.salary - u.getSalary();
		if(diff == 0){
			return this.name.compareTo(u.getName());
		}
		return diff;
	}
	@Override
	public String toString(){
		String s;
		s = " [ 이름 : "+this.name + " , 월급 : " +this.salary+" ] ";
		return s;
	}
}
