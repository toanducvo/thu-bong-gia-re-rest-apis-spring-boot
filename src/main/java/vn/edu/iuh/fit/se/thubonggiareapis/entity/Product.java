package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "products")
public class Product {
	
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
	private double cost;
	
	@Column
	private String description;
	
	@Column
	private String origin;
	
	@Column
	private String brand;
	
	@Column
	private int rate;
	
	@Column
	private String category;
	
	@Column
	private String material;
	
	@Column
	private double weight;
	
	@Column
	private double height;
	
	@Column
	private double width;
	
	@Column
	private final String measuredUnit = "cm";
	
	@OneToMany(mappedBy = "product")
	private Set<CartDetail> cartDetails;
	
	@OneToMany(mappedBy = "product")
	private Set<OrderDetail> orderDetails;

	
}
