package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "promotions")
public class Promotion {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", unique = true, updatable = false)
	private UUID id;

	private String promotionCode; //note
	
	@Column(nullable = false, updatable = false)
	@ManyToOne
	@JoinColumn(name = "userId")
	private User createdBy;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime expiredDate;
	
	@Column(nullable = false, updatable = false)
	private double deducted;
	
	@Column(nullable = false, updatable = false)
	private int limit;
	
	@OneToMany(mappedBy = "promotion")
	private Set<Order> orders;
	

}
