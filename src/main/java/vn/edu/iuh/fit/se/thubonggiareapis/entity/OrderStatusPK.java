package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import java.io.Serializable;
import java.util.Objects;

public class OrderStatusPK implements Serializable{
	private Order order;
	private String status;
	public OrderStatusPK() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(order, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderStatusPK other = (OrderStatusPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(status, other.status);
	}
	
	
}
