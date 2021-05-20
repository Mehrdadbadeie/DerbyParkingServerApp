package se.yrgo.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Customer implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String firstname;
	private String lastname;

	/**
	 * Create a person that can park a vehicle.
	 * 
	 * @param firstname Firstname of person who can drive a car.
	 * @param lastname  Lastname of person who can drive a car.
	 */
	public Customer(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Customer() {
	}
}
