package com.vinisolon.repository;

import com.vinisolon.entity.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    public List<Customer> listAllCustomers() {
        return this.findAll(Sort.descending("firstName")).list();
    }

}
