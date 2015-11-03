package com.baseev.manager.impl;


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
        customerDao.create(INSERT, new Object[] { customer.getName(),customer.getCreated()});
        return customer;
    }

    @Override
    public boolean update(Long id, Customer customer)
    {
        int flag = customerDao.update(UPDATE, new Object[] { customer.getName(),customer.getCreated()});
        return flag ==0 ? false : true;
    }

    @Override
    public Customer read(Long id)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Customer> search(Map<String, Object> map)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean delete(Long id)
    {
        // TODO Auto-generated method stub
        return false;
    }
    
    
    @Resource(name = CustomerDao.BEAN_NAME)
    public void setCustomerDao(
            CustomerDao a_customerDao)
    {
        customerDao = a_customerDao;
    }  

}
