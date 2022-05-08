package vn.edu.iuh.fit.se.thubonggiareapis.service;

import org.springframework.stereotype.Service;

import vn.edu.iuh.fit.se.thubonggiareapis.dto.CustomerDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Customer;

@Service
public interface ICustomerService {
	CustomerDTO getCustomer(long id);
	CustomerDTO addCustomer(CustomerDTO customerDTO);
}
