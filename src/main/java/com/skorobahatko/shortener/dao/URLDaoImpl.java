package com.skorobahatko.shortener.dao;

import com.skorobahatko.shortener.exception.DatabaseURLGetException;
import com.skorobahatko.shortener.exception.DatabaseURLSaveException;
import com.skorobahatko.shortener.model.URL;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class URLDaoImpl implements URLDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public long save(final URL url) throws DatabaseURLSaveException {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.persist(url);
            return getId(session, url);
        } catch (HibernateException e) {
            throw new DatabaseURLSaveException("Can't save URL to database", e);
        }
    }

    @Override
    @Transactional
    public URL getById(long id) throws DatabaseURLGetException {
        try {
            Session session = sessionFactory.openSession();
            return session.load(URL.class, id);
        } catch (HibernateException e) {
            throw new DatabaseURLGetException("Can't get URL from database", e);
        }
    }

    private long getId(Session session, final URL originalURL) throws HibernateException {
        Query query = session.createQuery("FROM URL WHERE value = :value");
        query.setParameter("value", originalURL.getUrl());
        List<URL> list = query.list();
        return list.get(0).getId();
    }

}
