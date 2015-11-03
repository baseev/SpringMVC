package com.baseev.base.dao;

public interface EntityDao
{
    public Object create(final String query, final Object[] parameters);

    public int update(final String query, final Object[] parameters);

    public Object read(final String query, final Object[] parameters);

    public Object search(final String query, final Object[] parameters);
    
    public int delete(final String query, final Object[] parameters);
}
