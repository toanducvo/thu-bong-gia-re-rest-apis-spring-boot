package vn.edu.iuh.fit.se.thubonggiareapis.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import vn.edu.iuh.fit.se.thubonggiareapis.entity.CartDetail;

public class CartDTO {
	private String token;
	private LocalDateTime createdAt;
	private LocalDateTime expiredAt;
	
	
	public CartDTO() {
		super();
	}


	public CartDTO(String token) {
		super();
		this.token = token;
	}


	public CartDTO(String token, LocalDateTime createdAt, LocalDateTime expiredAt) {
		super();
		this.token = token;
		this.createdAt = createdAt;
		this.expiredAt = expiredAt;
	}


	public LocalDateTime getExpiredAt() {
		return expiredAt;
	}


	public void setExpiredAt(LocalDateTime expiredAt) {
		this.expiredAt = expiredAt;
	}


	public String getToken() {
		return token;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	@Override
	public String toString() {
		return "CartDTO [token=" + token + ", createdAt=" + createdAt + ", expiredAt=" + expiredAt + "]";
	}
	
	
}
