package com.baseev.manager;

import java.util.List;
import java.util.Map;

import com.baseev.model.Customer;

public interface CustomerManager
{
    public static final String BEAN_NAME    = "customerManager";   
    
    
    public static final String INSERT       = "INSERT INTO customer(name, email, created) VALUES(?, ?, ?)";
    public static final String UPDATE       = "UPDATE customer set name=? email=? updated=?";
    public static final String DELETE       = "DELETE FROM customer WHERE id=?";
    public static final String SELECT       = "SELECT * FROM customer WHERE id=?";
    public static final String SEARCH       = "INSERT INTO customer(name, created) VALUES(?, ?)";
    
    
    public Customer create(final Customer customer);

    public boolean update(final Long id, final Customer customer);

    public Customer read(final Long id);

    public List<Customer> search(Map<String, Object> map);
    
    public boolean delete(final Long id);
}
