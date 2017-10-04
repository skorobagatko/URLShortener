package com.skorobahatko.shortener.dao;

import com.skorobahatko.shortener.exception.DatabaseURLGetException;
import com.skorobahatko.shortener.exception.DatabaseURLSaveException;
import com.skorobahatko.shortener.model.URL;
import com.skorobahatko.shortener.exception.DatabaseException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class URLDaoImpl implements URLDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public long save(final URL url) throws DatabaseURLSaveException {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.persist(url);
            return getId(url);
        } catch (HibernateException e) {
            throw new DatabaseURLSaveException("Can't save URL to database", e);
        }
    }

    @Override
    public URL getById(long id) throws DatabaseURLGetException {
        try {
            Session session = sessionFactory.getCurrentSession();
            return session.load(URL.class, id);
        } catch (HibernateException e) {
            throw new DatabaseURLGetException("Can't save URL to database", e);
        }
    }

    private long getId(final URL url) throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        return session.load(URL.class, url.getUrl()).getId();
    }

}
