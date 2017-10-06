package com.skorobahatko.shortener.dao;

import com.skorobahatko.shortener.exception.DatabaseURLGetException;
import com.skorobahatko.shortener.exception.DatabaseURLSaveException;
import com.skorobahatko.shortener.model.URL;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.lang.Nullable;
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
    public @Nullable URL getById(long id) throws DatabaseURLGetException {
        try {
            Session session = sessionFactory.getCurrentSession();
            return session.get(URL.class, id);
        } catch (HibernateException e) {
            throw new DatabaseURLGetException("Can't get URL from database", e);
        }
    }

    @SuppressWarnings("unchecked")
    private long getId(Session session, final URL originalURL) throws HibernateException {
        Query<URL> query = session.createQuery("FROM URL WHERE value = :value");
        query.setParameter("value", originalURL.getUrl());
        URL result = query.getSingleResult();
        return result.getId();
    }

}
