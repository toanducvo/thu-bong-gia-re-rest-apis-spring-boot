package vn.edu.iuh.fit.se.thubonggiareapis.entity;

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
	private Set<Order> orders;
	
}
