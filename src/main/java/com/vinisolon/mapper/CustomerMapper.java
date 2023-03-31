package com.vinisolon.mapper;

import com.vinisolon.entity.Customer;
import com.vinisolon.request.CustomerRequest;
import com.vinisolon.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface CustomerMapper {

    CustomerResponse toResponse(Customer customer);

    Customer toEntity(CustomerRequest dto);

    void updateEntity(@MappingTarget Customer entity, CustomerRequest request);
}
