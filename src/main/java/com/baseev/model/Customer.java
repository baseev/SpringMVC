package com.baseev.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties("true")
public class Customer
{
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("created")
    private Date created;
    @JsonProperty("updated")
    private Date updated;
    
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public Date getCreated()
    {
        return created;
    }
    public void setCreated(Date created)
    {
        this.created = created;
    }
    
    public Date getUpdated()
    {
        return updated;
    }
    public void setUpdated(Date updated)
    {
        this.updated = updated;
    }
    
    
    @Override
    public String toString()
    {
        return "Customer [id=" + id + ", name=" + name + ", email=" + email
                + ", created=" + created + ", updated=" + updated + "]";
    }    
}
