package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "carts")
public class Cart {
	
	@Id
	private String token;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(nullable = false, updatable = false)
	private LocalDateTime expiredAt;
	
	@OneToMany(mappedBy = "cart")
	private Set<CartDetail> cartDetails;
	
}
