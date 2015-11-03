package com.baseev.dao.impl;

import com.baseev.base.dao.impl.BaseDao;
import com.baseev.dao.CustomerDao;


public class CustomerDaoImpl 
    extends BaseDao 
    implements CustomerDao
{
    @Override
    public Object create(final String query, final Object[] params)
    {
        return getJdbcTemplate().update(query, params);
    }

    @Override
    public int update(String query, Object[] parameters)
    {
        return getJdbcTemplate().update(query, parameters);
    }

    @Override
    public Object read(String query, Object[] parameters)
    {
        return getJdbcTemplate().queryForList(query, parameters);
    }

    @Override
    public Object search(String query, Object[] parameters)
    {
        return getJdbcTemplate().queryForList(query, parameters);
    }

    @Override
    public int delete(String query, Object[] parameters)
    {
        return getJdbcTemplate().update(query, parameters);
    }
}
