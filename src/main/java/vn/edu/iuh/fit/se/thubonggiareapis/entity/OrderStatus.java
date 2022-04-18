package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(OrderStatusPK.class)
@Table(name = "orderStatus")
public class OrderStatus {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@Column(nullable = false, updatable = false)
	private String status;
	
	@Id
	@Column(nullable = false, updatable = false)
	private LocalDateTime timestamp;
	
	@Column(nullable = false, updatable = false)
	private String statusNote;

	public OrderStatus() {
		super();
	}

	public OrderStatus(Order order, String status, LocalDateTime timestamp, String statusNote) {
		super();
		this.order = order;
		this.status = status;
		this.timestamp = timestamp;
		this.statusNote = statusNote;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatusNote() {
		return statusNote;
	}

	public void setStatusNote(String statusNote) {
		this.statusNote = statusNote;
	}

	@Override
	public String toString() {
		return "OrderStatus [order=" + order + ", status=" + status + ", timestamp=" + timestamp + ", statusNote="
				+ statusNote + "]";
	}
	
	
}
