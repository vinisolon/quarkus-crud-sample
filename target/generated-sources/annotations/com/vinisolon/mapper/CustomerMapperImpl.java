package com.vinisolon.mapper;

import com.vinisolon.entity.Customer;
import com.vinisolon.request.CustomerRequest;
import com.vinisolon.response.CustomerResponse;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-31T17:30:39-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16 (Amazon.com Inc.)"
)
@ApplicationScoped
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerResponse toResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setFullName( customer.getFullName() );
        customerResponse.setEmail( customer.getEmail() );
        customerResponse.setAge( customer.getAge() );

        return customerResponse;
    }

    @Override
    public Customer toEntity(CustomerRequest dto) {
        if ( dto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setFirstName( dto.getFirstName() );
        customer.setLastName( dto.getLastName() );
        customer.setBirthDate( dto.getBirthDate() );
        customer.setEmail( dto.getEmail() );
        customer.id = dto.getId();

        return customer;
    }

    @Override
    public void updateEntity(Customer entity, CustomerRequest request) {
        if ( request == null ) {
            return;
        }

        entity.setFirstName( request.getFirstName() );
        entity.setLastName( request.getLastName() );
        entity.setBirthDate( request.getBirthDate() );
        entity.setEmail( request.getEmail() );
        entity.id = request.getId();
    }
}
