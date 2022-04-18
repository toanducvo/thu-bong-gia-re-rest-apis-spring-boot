package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", unique = true, updatable = false)
	private UUID id;
	
	@Column(nullable = false)
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String phoneNumber;
	
	@OneToMany(mappedBy = "customer")
	private List<Order> orders = new ArrayList<Order>();

	public Customer() {
		super();
	}

	public Customer(UUID id) {
		super();
		this.id = id;
	}

	public Customer(UUID id, String name, String email, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
}
