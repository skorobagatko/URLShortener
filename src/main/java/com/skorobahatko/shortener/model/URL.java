package com.skorobahatko.shortener.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="url")
public class URL implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="url")
    private String url;

    public URL() {}

    public URL(String url) {
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "URL{" +
                "url='" + url + '\'' +
                '}';
    }
}
