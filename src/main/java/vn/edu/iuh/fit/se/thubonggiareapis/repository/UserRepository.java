package vn.edu.iuh.fit.se.thubonggiareapis.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.edu.iuh.fit.se.thubonggiareapis.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
	
}
