package com.baseev.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer
{
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("created")
    private Date created;

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    
    public Date getCreated()
    {
        return created;
    }
    public void setCreated(Date created)
    {
        this.created = created;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Data [name=");
        builder.append(name);
        builder.append(", created=");
        builder.append(created);
        builder.append("]");
        return builder.toString();
    }
    
    
}
