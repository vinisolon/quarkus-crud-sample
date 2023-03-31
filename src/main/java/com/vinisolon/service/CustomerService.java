package com.vinisolon.service;

import com.vinisolon.entity.Customer;
import com.vinisolon.exception.ObjectNotFoundException;
import com.vinisolon.mapper.CustomerMapper;
import com.vinisolon.repository.CustomerRepository;
import com.vinisolon.request.CustomerRequest;
import com.vinisolon.response.CustomerResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static com.vinisolon.constants.ExceptionMessage.OBJECT_NOT_FOUND;

@ApplicationScoped
public class CustomerService {

    @Inject
    CustomerRepository customerRepository;

    @Inject
    CustomerMapper customerMapper;

    public List<CustomerResponse> listAllCustomers() {
        return customerRepository.listAllCustomers()
                .stream()
                .map(customer -> customerMapper.toResponse(customer))
                .collect(Collectors.toList());
    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findByIdOptional(id)
                .orElseThrow(() -> new ObjectNotFoundException(OBJECT_NOT_FOUND));
    }

    @Transactional
    public CustomerResponse create(CustomerRequest customerRequest) {
        Customer customer = customerMapper.toEntity(customerRequest);
        customerRepository.persist(customer);
        return customerMapper.toResponse(customer);
    }

    @Transactional
    public CustomerResponse update(CustomerRequest customerRequest) {
        Customer customerToUpdate = this.findCustomerById(customerRequest.getId());
        customerMapper.updateEntity(customerToUpdate, customerRequest);
        customerRepository.persist(customerToUpdate);
        return customerMapper.toResponse(customerToUpdate);
    }

    @Transactional
    public void deleteCustomer(Long id) {
        this.findCustomerById(id);
        customerRepository.deleteById(id);
    }
}
