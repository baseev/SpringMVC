package com.baseev.web.controller;


import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
        view.setData(customerData);
        return view.getView();
    }   
    
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ModelAndView update(@PathVariable("id") Long id, @RequestBody Customer customer, ModelMap model) {
        boolean flag = customerManager.update(id, customer);
        ViewHelper view = new ViewHelper();
        view.setStatus("success");
        view.setData("Created a stack with size "+customer);
        return view.getView();
    } 
        
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/read/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView read(@PathVariable("id") Long id, ModelMap model) {
        Customer customer = customerManager.read(id);
        ViewHelper view = new ViewHelper();
        view.setStatus("success");
        view.setData(customer);
        return view.getView();
    } 
    
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/search/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView search(@RequestBody Customer customer, ModelMap model) {
        ViewHelper view = new ViewHelper();
        view.setStatus("success");
        view.setData("Created a stack with size "+customer);
        return view.getView();
    } 
        
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public ModelAndView delete(@RequestBody Long id, ModelMap model) {
        boolean flag = customerManager.delete(id);
        ViewHelper view = new ViewHelper();
        view.setStatus("success");
        view.setData("Created a stack with size "+id);
        return view.getView();
    } 
    
    
   
   @Resource(name = CustomerManager.BEAN_NAME)
   public void setCustomerManager(
           CustomerManager a_customerManager)
   {
       customerManager = a_customerManager;
   }   
}