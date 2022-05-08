package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.iuh.fit.se.thubonggiareapis.dto.CustomerDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.service.ICustomerService;

@RestController
public class CustomerController {
	
	
	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/customers/{customerId}")
	public CustomerDTO getCustomer(@PathVariable long customerId) {
		CustomerDTO customerDTO = customerService.getCustomer(customerId);
		return customerDTO;
	}
	
	@PostMapping(value = "/customers", consumes = MediaType.ALL_VALUE)
	public CustomerDTO addCustomer(@RequestBody CustomerDTO model) {
		return customerService.addCustomer(model);
	}
}
