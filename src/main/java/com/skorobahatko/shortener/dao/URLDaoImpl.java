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
            // Check if url is already in database
            URL urlFromDB = getUrlFromDatabase(session, url);
            if (urlFromDB == null) {
                // Add new url to database
                session.persist(url);
                // Return id from database for this new url
                return getId(session, url);
            } else {
                // return id of equal url in database
                return getId(session, urlFromDB);
            }
        } catch (HibernateException e) {
            throw new DatabaseURLSaveException("Can't save URL to database", e);
        }
    }

    @Override
    public @Nullable URL getById(long id) throws DatabaseURLGetException {
        try {
            Session session = sessionFactory.getCurrentSession();
            URL result = session.get(URL.class, id);
            if (result == null)
                throw new DatabaseURLGetException("ID " + id + " has no mapped url in database");
            return result;
        } catch (HibernateException e) {
            throw new DatabaseURLGetException("Can't get URL from database", e);
        }
    }

    @SuppressWarnings("unchecked")
    private URL getUrlFromDatabase(Session session, URL url) {
        Query<URL> query = session.createQuery("FROM URL WHERE value = :value");
        query.setParameter("value", url.getUrl());
        return query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    private long getId(Session session, final URL originalURL) throws HibernateException {
        Query<URL> query = session.createQuery("FROM URL WHERE value = :value");
        query.setParameter("value", originalURL.getUrl());
        URL result = query.getSingleResult();
        return result.getId();
    }

}
