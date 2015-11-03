package com.baseev.base.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.baseev.base.dao.EntityDao;


public abstract class BaseDao 
    extends JdbcDaoSupport 
    implements EntityDao
{

    @Override
    public Object create(final String query,final  Object[] parameters)
    {
        return getJdbcTemplate().update(query, parameters);
    }

    @Override
    public int update(final String query, final Object[] parameters)
    {
        return getJdbcTemplate().update(query, parameters);
    }

    @Override
    public Object read(final String query, final Object[] parameters)
    {
        return getJdbcTemplate().queryForList(query, parameters);
    }

    @Override
    public Object search(final String query, final Object[] parameters)
    {
        return getJdbcTemplate().queryForList(query, parameters);
    }

    @Override
    public int delete(final String query, final Object[] parameters)
    {
        return getJdbcTemplate().update(query, parameters);
    }
}
