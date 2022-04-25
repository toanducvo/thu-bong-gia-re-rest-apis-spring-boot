package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
    @GenericGenerator(
            name = "UUID",
            strategy = "uuid")
	@Column(name = "id", unique = true, updatable = false, columnDefinition = "CHAR(36)")
	private String id;

	private String promotionCode; //note
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User createdBy;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime expiredDate;
	
	@Column(nullable = false, updatable = false)
	private double deducted;
	
	@Column(nullable = false, updatable = false)
	private int limit;
	
	@OneToMany(mappedBy = "promotion")
	private List<Order> orders = new ArrayList<Order>();

	public Promotion() {
		super();
	}

	public Promotion(String id) {
		super();
		this.id = id;
	}

	public Promotion(String promotionCode, User createdBy, LocalDateTime expiredDate, double deducted, int limit) {
		super();
		this.promotionCode = promotionCode;
		this.createdBy = createdBy;
		this.expiredDate = expiredDate;
		this.deducted = deducted;
		this.limit = limit;
	}

	public Promotion(String id, String promotionCode, User createdBy, LocalDateTime expiredDate, double deducted,
			int limit) {
		super();
		this.id = id;
		this.promotionCode = promotionCode;
		this.createdBy = createdBy;
		this.expiredDate = expiredDate;
		this.deducted = deducted;
		this.limit = limit;
	}

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(LocalDateTime expiredDate) {
		this.expiredDate = expiredDate;
	}

	public double getDeducted() {
		return deducted;
	}

	public void setDeducted(double deducted) {
		this.deducted = deducted;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Promotion [id=" + id + ", promotionCode=" + promotionCode + ", createdBy=" + createdBy
				+ ", expiredDate=" + expiredDate + ", deducted=" + deducted + ", limit=" + limit + "]";
	}

	

	
	

}
