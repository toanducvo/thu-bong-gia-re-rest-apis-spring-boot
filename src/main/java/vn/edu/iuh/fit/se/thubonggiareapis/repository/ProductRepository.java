package vn.edu.iuh.fit.se.thubonggiareapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.edu.iuh.fit.se.thubonggiareapis.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
