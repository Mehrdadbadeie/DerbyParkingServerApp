package se.yrgo.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ParkingTicket implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private LocalDate validThroughBegin;
	private LocalDate validThroughEnd;
	private int pricePerhour;
	private String streetAddress;

	@ManyToOne
	private Car car;

	@ManyToOne
	private Customer customer;

	/**
	 * Create a new parking ticket for a specific customer, street address and
	 * vehicle.
	 * 
	 * @param validThroughBegin The time and date before which onward this parking
	 *                          ticket is valid.
	 * @param validThroughEnd   Car that this parking ticket has been issued for.
	 * @param pricePerhour      How much customer will be charged per hour to park
	 *                          at this location.
	 * @param streetAddress     Street address that this parking ticket is valid
	 *                          for.
	 * @param car               Car that this parking ticket has been issued for.
	 * @param customer
	 */
	public ParkingTicket(LocalDate validThroughBegin, LocalDate validThroughEnd, int pricePerhour,
			String parkingLocation, Car car, Customer customer) {
		super();
		this.validThroughBegin = validThroughBegin;
		this.validThroughEnd = validThroughEnd;
		this.pricePerhour = pricePerhour;
		this.streetAddress = parkingLocation;
		this.car = car;
		this.customer = customer;
	}

	public ParkingTicket() {
	}
}
