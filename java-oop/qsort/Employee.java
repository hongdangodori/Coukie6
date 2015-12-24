package com.coupang.samples.oop.sort;

import java.math.BigDecimal;

/**
 * Created by andew on 2015. 12. 24..
 */
public class Employee {
	String name;
	int id;
	BigDecimal wage;

	public Employee(String name, int id, BigDecimal wage) {
		this.name = name;
		this.id = id;
		this.wage = wage;
	}

	@Override
	public String toString(){
		return name + "/" + id + "/" + wage;
	}

}
