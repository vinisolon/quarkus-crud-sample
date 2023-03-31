package com.vinisolon.controller;

import com.vinisolon.mapper.CustomerMapper;
import com.vinisolon.request.CustomerRequest;
import com.vinisolon.response.CustomerResponse;
import com.vinisolon.service.CustomerService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/customers")
public class CustomerController {

    @Inject
    CustomerService customerService;

    @Inject
    CustomerMapper customerMapper;

    @GET
    public List<CustomerResponse> listAllCustomers() {
        return customerService.listAllCustomers();
    }

    @GET
    @Path("/{id}")
    public CustomerResponse findCustomerById(Long id) {
        return customerMapper.toResponse(customerService.findCustomerById(id));
    }

    @POST
    public Response createCustomer(CustomerRequest customerRequest) {
        return Response.ok().entity(customerService.create(customerRequest)).build();
    }

    @PUT
    public Response updateCustomer(CustomerRequest customerRequest) {
        return Response.ok().entity(customerService.update(customerRequest)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(Long id) {
        customerService.deleteCustomer(id);
        return Response.noContent().build();
    }
}