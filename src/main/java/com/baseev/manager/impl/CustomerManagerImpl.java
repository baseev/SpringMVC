package com.baseev.manager.impl;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baseev.dao.CustomerDao;
import com.baseev.manager.CustomerManager;
import com.baseev.model.Customer;

@Service(CustomerManager.BEAN_NAME)
public class CustomerManagerImpl
    implements CustomerManager
{

    private CustomerDao customerDao;
    
    @Override
    public Customer create(Customer customer)
    {
        customerDao.create(INSERT, new Object[] { customer.getName(), customer.getEmail(), customer.getCreated()});
        return customer;
    }

    @Override
    public boolean update(Long id, Customer customer)
    {
        int flag = customerDao.update(UPDATE, new Object[] {customer.getName(), customer.getEmail(), new Date(), customer.getId()});
        return flag ==0 ? false : true;
    }

    @Override
    public Customer read(final Long id)
    {
        return (Customer) customerDao.read(SELECT, new Object[] {id});
    }

    @Override
    public List<Customer> search(Map<String, Object> map)
    {
        return (List<Customer>) customerDao.search(SEARCH, new Object[] {map});
    }

    @Override
    public boolean delete(final Long id)
    {
        int flag =  customerDao.delete(DELETE, new Object[] {id});
        return flag ==0 ? false : true;
    }
    
    
    @Resource(name = CustomerDao.BEAN_NAME)
    public void setCustomerDao(
            CustomerDao a_customerDao)
    {
        customerDao = a_customerDao;
    }  

}
