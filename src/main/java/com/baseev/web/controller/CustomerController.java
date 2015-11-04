package com.baseev.web.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baseev.common.helper.ViewHelper;
import com.baseev.manager.CustomerManager;
import com.baseev.model.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private static final Log LOG = LogFactory.getLog(CustomerController.class);
    private CustomerManager customerManager;
    
    
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/create", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView create(@RequestBody Customer customer, ModelMap model) {
        Customer customerData = customerManager.create(customer);
        ViewHelper view = new ViewHelper();
        view.setStatus("success");
        if(customerData == null) {
            view.setStatus("error");
        }
        view.setData(customerData);
        LOG.info("Setting the view object from create method "+view);
        return view.getView();
    }   
    
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ModelAndView update(@PathVariable("id") Long id, @RequestBody Customer customer, ModelMap model) {
        boolean flag = customerManager.update(id, customer);
        ViewHelper view = new ViewHelper();
        view.setStatus("success");
        if(!flag) {
            view.setStatus("error");
        }
        view.setData(customer);
        LOG.info("Setting the view object from update method "+view);
        return view.getView();
    } 
        
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/read/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView read(@PathVariable("id") Long id, ModelMap model) {
        Customer customer = customerManager.read(id);
        ViewHelper view = new ViewHelper();
        view.setStatus("success");
        view.setData(customer);
        LOG.info("Setting the view object from read method "+view);
        return view.getView();
    } 
    
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/search", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView search(@PathVariable("id") Long id, ModelMap model) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Customer> customers = customerManager.search(map);
        ViewHelper view = new ViewHelper();
        view.setStatus("success");
        view.setData(customers);
        LOG.info("Setting the view object from search method "+view);
        return view.getView();
    } 
        
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public ModelAndView delete(@RequestBody Long id, ModelMap model) {
        boolean flag = customerManager.delete(id);
        ViewHelper view = new ViewHelper();
        view.setStatus("success");
        if(!flag) {
            view.setStatus("error"); 
        }
        view.setData("Successfully deleted the id "+id);
        LOG.info("Setting the view object from delete method "+view);
        return view.getView();
    } 
    
    
    public void afterPropertiesSet()
            throws Exception
    {
        Assert.notNull(customerManager,
                CustomerManager.class.getName() + " is not set for " + getClass().getName());
    }
   
   @Resource(name = CustomerManager.BEAN_NAME)
   public void setCustomerManager(
           CustomerManager a_customerManager)
   {
       customerManager = a_customerManager;
   }   
}