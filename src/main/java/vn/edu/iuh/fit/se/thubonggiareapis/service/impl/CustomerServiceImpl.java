package vn.edu.iuh.fit.se.thubonggiareapis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.converter.CustomerConverter;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.CustomerDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Customer;
import vn.edu.iuh.fit.se.thubonggiareapis.repository.CustomerRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter customerConverter;

    @Override
    public CustomerDTO getCustomer(long id) {
        Customer customer = customerRepository.getById(id);
        CustomerDTO customerDTO = customerConverter.toCustomerDTO(customer);
        return customerDTO;
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer customer = customerConverter.toCustomerEntity(customerDTO);
        customer = customerRepository.save(customer);
        return customerConverter.toCustomerDTO(customer);
    }

}
